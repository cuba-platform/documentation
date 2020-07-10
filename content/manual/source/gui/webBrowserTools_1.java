@Inject
private WebBrowserTools webBrowserTools;

@Subscribe("button")
public void onButtonClick(Button.ClickEvent event) {
    webBrowserTools.showWebPage("https://cuba-platform.com", ParamsMap.of("_target", "blank"));
}