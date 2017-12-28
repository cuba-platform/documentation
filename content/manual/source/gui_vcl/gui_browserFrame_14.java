@Inject
private BrowserFrame browserFrame;
@Inject
private Resources resources;

@Override
public void init(Map<String, Object> params) {
    browserFramePdf.setSource(StreamResource.class)
            .setStreamSupplier(() -> resources.getResourceAsStream("/com/company/demo/" +
                    "web/screens/CUBA_Hands_on_Lab_6.8.pdf"))
            .setMimeType("application/pdf");
}