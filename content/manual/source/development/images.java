public class EmployeeEdit extends AbstractEditor<Employee> {

    private Logger log = LoggerFactory.getLogger(EmployeeEdit.class);

    @Inject
    private DataSupplier dataSupplier;
    @Inject
    private FileStorageService fileStorageService;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private ExportDisplay exportDisplay;

    @Inject
    private Embedded embeddedImage;
    @Inject
    private FileUploadField uploadField;
    @Inject
    private Button downloadImageBtn;
    @Inject
    private Button clearImageBtn;
    @Inject
    private Datasource<Employee> employeeDs;

    private static final int IMG_HEIGHT = 190;
    private static final int IMG_WIDTH = 220;

    @Override
    public void init(Map<String, Object> params) {
        uploadField.addFileUploadSucceedListener(event -> {
            FileDescriptor fd = uploadField.getFileDescriptor();
            try {
                fileUploadingAPI.putFileIntoStorage(uploadField.getFileId(), fd);
            } catch (FileStorageException e) {
                throw new RuntimeException("Error saving file to FileStorage", e);
            }
            getItem().setImageFile(dataSupplier.commit(fd));
            displayImage();
        });

        uploadField.addFileUploadErrorListener(event ->
                showNotification("File upload error", NotificationType.HUMANIZED));

        employeeDs.addItemPropertyChangeListener(event -> {
            if ("imageFile".equals(event.getProperty()))
                updateImageButtons(event.getValue() != null);
        });
    }

    @Override
    protected void postInit() {
        displayImage();
        updateImageButtons(getItem().getImageFile() != null);
    }

    public void onDownloadImageBtnClick() {
        if (getItem().getImageFile() != null)
            exportDisplay.show(getItem().getImageFile(), ExportFormat.OCTET_STREAM);
    }

    public void onClearImageBtnClick() {
        getItem().setImageFile(null);
        displayImage();
    }

    private void updateImageButtons(boolean enable) {
        downloadImageBtn.setEnabled(enable);
        clearImageBtn.setEnabled(enable);
    }

    private void displayImage() {
        byte[] bytes = null;
        if (getItem().getImageFile() != null) {
            try {
                bytes = fileStorageService.loadFile(getItem().getImageFile());
            } catch (FileStorageException e) {
                log.error("Unable to load image file", e);
                showNotification("Unable to load image file", NotificationType.HUMANIZED);
            }
        }
        if (bytes != null) {
            embeddedImage.setSource(getItem().getImageFile().getName(), new ByteArrayInputStream(bytes));
            embeddedImage.setType(Embedded.Type.IMAGE);
            BufferedImage image;
            try {
                image = ImageIO.read(new ByteArrayInputStream(bytes));
                int width = image.getWidth();
                int height = image.getHeight();

                if (((double) height / (double) width) > ((double) IMG_HEIGHT / (double) IMG_WIDTH)) {
                    embeddedImage.setHeight(String.valueOf(IMG_HEIGHT));
                    embeddedImage.setWidth(String.valueOf(width * IMG_HEIGHT / height));
                } else {
                    embeddedImage.setWidth(String.valueOf(IMG_WIDTH));
                    embeddedImage.setHeight(String.valueOf(height * IMG_WIDTH / width));
                }
            } catch (IOException e) {
                log.error("Unable to resize image", e);
            }
            // refresh image
            embeddedImage.setVisible(false);
            embeddedImage.setVisible(true);
        } else {
            embeddedImage.setVisible(false);
        }
    }
}