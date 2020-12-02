private RequestHandler facebookCallBackRequestHandler =
        this::handleFacebookCallBackRequest;

private URI redirectUri;

@Inject
private FacebookService facebookService;

@Inject
private GlobalConfig globalConfig;

@Subscribe("facebookBtn")
public void onFacebookBtnClick(Button.ClickEvent event) {
    VaadinSession.getCurrent()
        .addRequestHandler(facebookCallBackRequestHandler);

    this.redirectUri = Page.getCurrent().getLocation();

    String loginUrl = facebookService.getLoginUrl(globalConfig.getWebAppUrl(), FacebookService.OAuth2ResponseType.CODE);
    Page.getCurrent()
        .setLocation(loginUrl);
}