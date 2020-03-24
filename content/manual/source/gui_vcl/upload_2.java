@Inject
private FileUploadField uploadField;
@Inject
private FileUploadingAPI fileUploadingAPI;
@Inject
private DataManager dataManager;
@Inject
private Notifications notifications;

@Subscribe("uploadField")
public void onUploadFieldFileUploadSucceed(FileUploadField.FileUploadSucceedEvent event) {
    File file = fileUploadingAPI.getFile(uploadField.getFileId()); <1>
    if (file != null) {
        notifications.create()
                .withCaption("File is uploaded to temporary storage at " + file.getAbsolutePath())
                .show();
    }

    FileDescriptor fd = uploadField.getFileDescriptor(); <2>
    try {
        fileUploadingAPI.putFileIntoStorage(uploadField.getFileId(), fd); <3>
    } catch (FileStorageException e) {
        throw new RuntimeException("Error saving file to FileStorage", e);
    }
    dataManager.commit(fd); <4>
    notifications.create()
            .withCaption("Uploaded file: " + uploadField.getFileName())
            .show();
}

@Subscribe("uploadField")
public void onUploadFieldFileUploadError(UploadField.FileUploadErrorEvent event) {
    notifications.create()
            .withCaption("File upload error")
            .show();
}