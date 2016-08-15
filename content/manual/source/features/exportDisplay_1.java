public class SampleScreen extends AbstractWindow {

    @Inject
    private ExportDisplay exportDisplay;

    public void onDownloadBtnClick(Component source) {
        String html = "<html><head title='Test'></head><body><h1>Test</h1></body></html>";
        byte[] bytes;
        try {
            bytes = html.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        exportDisplay.show(new ByteArrayDataProvider(bytes), "test.html", ExportFormat.HTML);
    }
}