@Inject
private Embedded embedded;

@Inject
private FileStorageService fileStorageService;

@Override
public void init(Map<String, Object> params) {
    FileDescriptor imageFile = (FileDescriptor) params.get("imageFile");

    byte[] bytes = null;
    if (imageFile != null) {
        try {
            bytes = fileStorageService.loadFile(imageFile);
        } catch (FileStorageException e) {
            showNotification("Unable to load image file", NotificationType.HUMANIZED);
        }
    }

    if (bytes != null) {
        embedded.setSource(imageFile.getName(), new ByteArrayInputStream(bytes));
        embedded.setType(Embedded.Type.IMAGE);
    } else {
        embedded.setVisible(false);
    }
}