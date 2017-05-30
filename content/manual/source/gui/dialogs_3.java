FileUploadDialog dialog = (FileUploadDialog) openWindow("fileUploadDialog", OpenType.DIALOG);
dialog.addCloseWithCommitListener(() -> {
    UUID fileId = dialog.getFileId();
    String fileName = dialog.getFileName();

    FileDescriptor fileDescriptor = fileUploadingAPI.getFileDescriptor(fileId, fileName);
    // your logic here
});