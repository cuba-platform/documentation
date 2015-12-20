@Inject
private FileUploadField uploadField;
@Inject
private FileUploadingAPI fileUploadingAPI;
@Inject
private DataSupplier dataSupplier;

@Override
public void init(Map<String, Object> params) {
    uploadField.addFileUploadSucceedListener(event -> {
        FileDescriptor fd = uploadField.getFileDescriptor();
        try {
            // save file to FileStorage
            fileUploadingAPI.putFileIntoStorage(uploadField.getFileId(), fd);
        } catch (FileStorageException e) {
            throw new RuntimeException("Error saving file to FileStorage", e);
        }
        // save file descriptor to database
        dataSupplier.commit(fd);
        showNotification("Uploaded file: " + uploadField.getFileName(), NotificationType.HUMANIZED);
    });

    uploadField.addFileUploadErrorListener(event ->
            showNotification("File upload error", NotificationType.HUMANIZED));
}
