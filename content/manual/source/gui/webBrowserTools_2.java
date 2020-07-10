public class ExternalUrlMenuItemRunner implements Runnable {

    @Override
    public void run() {
        AppUI.getCurrent().getWebBrowserTools().showWebPage("http://www.cuba-platform.com", null);
    }
}