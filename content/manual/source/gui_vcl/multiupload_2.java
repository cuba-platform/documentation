@Inject
private FileMultiUploadField multiUploadField;
@Inject
private FileUploadingAPI fileUploadingAPI;
@Inject
private Notifications notifications;
@Inject
private DataManager dataManager;

@Subscribe
protected void onInit(InitEvent event) {

    multiUploadField.addQueueUploadCompleteListener(queueUploadCompleteEvent -> { <2>
        for (Map.Entry<UUID, String> entry : multiUploadField.getUploadsMap().entrySet()) { <3>
            UUID fileId = entry.getKey();
            String fileName = entry.getValue();
            FileDescriptor fd = fileUploadingAPI.getFileDescriptor(fileId, fileName); <4>
            try {
                fileUploadingAPI.putFileIntoStorage(fileId, fd); <5>
            } catch (FileStorageException e) {
                throw new RuntimeException("Error saving file to FileStorage", e);
            }
            dataManager.commit(fd); <6>
        }
        notifications.create()
                .withCaption("Uploaded files: " + multiUploadField.getUploadsMap().values())
                .show();
        multiUploadField.clearUploads(); <7>
    });

    multiUploadField.addFileUploadErrorListener(queueFileUploadErrorEvent -> {
        notifications.create()
                .withCaption("File upload error")
                .show();
    });
}
