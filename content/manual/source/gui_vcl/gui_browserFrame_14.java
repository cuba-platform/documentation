@Inject
private BrowserFrame browserFrame;
@Inject
private Resources resources;

@Subscribe
protected void onInit(InitEvent event) {
    browserFramePdf.setSource(StreamResource.class)
            .setStreamSupplier(() -> resources.getResourceAsStream("/com/company/demo/" +
                    "web/screens/CUBA_Hands_on_Lab_6.8.pdf"))
            .setMimeType("application/pdf");
}