@Inject
protected FileUploadField uploadField;

@Inject
protected FileUploadingAPI fileUploading;

@Inject
protected DataSupplier dataSupplier;

@Override
public void init(Map<String, Object> params) {
        uploadField.addListener(new FileUploadField.ListenerAdapter() {
@Override
public void uploadSucceeded(Event event) {
        FileDescriptor fd = uploadField.getFileDescriptor();
        try {
        // save file to FileStorage
        fileUploading.putFileIntoStorage(uploadField.getFileId(), fd);
        } catch (FileStorageException e) {
        throw new RuntimeException(e);
        }
        // save file descriptor to database
        dataSupplier.commit(fd, null);

        showNotification("File uploaded: " + uploadField.getFileName(), NotificationType.HUMANIZED);
        }

@Override
public void uploadFailed(Event event) {
        showNotification("File upload error", NotificationType.HUMANIZED);
        }
        });
        }