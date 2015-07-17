@Inject
protected FileMultiUploadField multiUploadField;

@Inject
protected FileUploadingAPI fileUploading;

@Inject
protected DataSupplier dataSupplier;

@Override
public void init(Map<String, Object> params) {
    multiUploadField.addListener(new FileMultiUploadField.UploadListener() {
        @Override
        public void queueUploadComplete() {
            Map<UUID, String> uploadMap = multiUploadField.getUploadsMap();
            for (Map.Entry<UUID, String> entry : uploadMap.entrySet()) {
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();
                FileDescriptor fd = fileUploading.getFileDescriptor(fileId, fileName);
                // save file to FileStorage
                try {
                    fileUploading.putFileIntoStorage(fileId, fd);
                } catch (FileStorageException e) {
                    new RuntimeException(e);
                }
                // save file descriptor to database
                dataSupplier.commit(fd, null);
            }
            multiUploadField.getUploadsMap().clear();
        }
    });
}