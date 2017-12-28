@Inject
private FileMultiUploadField multiUploadField;
@Inject
private FileUploadingAPI fileUploadingAPI;
@Inject
private DataSupplier dataSupplier;

@Override
public void init(Map<String, Object> params) {
    multiUploadField.addQueueUploadCompleteListener(() -> {
        for (Map.Entry<UUID, String> entry : multiUploadField.getUploadsMap().entrySet()) {
            UUID fileId = entry.getKey();
            String fileName = entry.getValue();
            FileDescriptor fd = fileUploadingAPI.getFileDescriptor(fileId, fileName);
            // save file to FileStorage
            try {
                fileUploadingAPI.putFileIntoStorage(fileId, fd);
            } catch (FileStorageException e) {
                throw new RuntimeException("Error saving file to FileStorage", e);
            }
            // save file descriptor to database
            dataSupplier.commit(fd);
        }
        showNotification("Uploaded files: " + multiUploadField.getUploadsMap().values(), NotificationType.HUMANIZED);
        multiUploadField.clearUploads();
    });

    multiUploadField.addFileUploadErrorListener(event ->
            showNotification("File upload error", NotificationType.HUMANIZED));
}