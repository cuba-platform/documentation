@Inject
private FileUploadField uploadField;
@Inject
private FileUploadingAPI fileUploadingAPI;
@Inject
private DataSupplier dataSupplier;

@Override
public void init(Map<String, Object> params) {
    uploadField.addFileUploadSucceedListener(event -> {
        // here you can get the file uploaded to the temporary storage if you need it
        File file = fileUploadingAPI.getFile(uploadField.getFileId());
        if (file != null) {
            showNotification("File is uploaded to temporary storage at " + file.getAbsolutePath());
        }

        // normally you would want to save the file to the file storage of the middle tier
        FileDescriptor fd = uploadField.getFileDescriptor();
        try {
            // save file to FileStorage
            fileUploadingAPI.putFileIntoStorage(uploadField.getFileId(), fd);
        } catch (FileStorageException e) {
            throw new RuntimeException("Error saving file to FileStorage", e);
        }
        // save file descriptor to database
        dataSupplier.commit(fd);
        showNotification("Uploaded file: " + uploadField.getFileName());
    });

    uploadField.addFileUploadErrorListener(event ->
            showNotification("File upload error"));
}
