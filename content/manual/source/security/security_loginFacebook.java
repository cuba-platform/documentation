private RequestHandler facebookCallBackRequestHandler =
        this::handleFacebookCallBackRequest;

private URI redirectUri;

@Inject
private FacebookService facebookService;

@Inject
private GlobalConfig globalConfig;

public void loginFacebook() {
    VaadinSession.getCurrent()
        .addRequestHandler(facebookCallBackRequestHandler);

    this.redirectUri = Page.getCurrent().getLocation();

    String loginUrl = facebookService.getLoginUrl(globalConfig.getWebAppUrl(), OAuth2ResponseType.CODE);
    Page.getCurrent()
        .setLocation(loginUrl);
}