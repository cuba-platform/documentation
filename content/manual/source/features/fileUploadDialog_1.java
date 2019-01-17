@Inject
private Screens screens;

@Inject
private FileUploadingAPI fileUploadingAPI;

@Inject
private DataManager dataManager;

@Subscribe("showUploadDialogBtn")
protected void onShowUploadDialogBtnClick(Button.ClickEvent event) {
    FileUploadDialog dialog = (FileUploadDialog) screens.create("fileUploadDialog", OpenMode.DIALOG);
    dialog.addCloseWithCommitListener(() -> {
        UUID fileId = dialog.getFileId();
        String fileName = dialog.getFileName();

        File file = fileUploadingAPI.getFile(fileId); // <1>

        FileDescriptor fileDescriptor = fileUploadingAPI.getFileDescriptor(fileId, fileName); // <2>
        try {
            fileUploadingAPI.putFileIntoStorage(fileId, fileDescriptor); // <3>
            dataManager.commit(fileDescriptor); // <4>
        } catch (FileStorageException e) {
            throw new RuntimeException(e);
        }
    });
    screens.show(dialog);
}