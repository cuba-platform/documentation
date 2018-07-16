@RestController
@RequestMapping("auth-code")
public class AuthCodeController {
    @Inject
    private OAuthTokenIssuer oAuthTokenIssuer;
    @Inject
    private LoginService loginService;
    @Inject
    private Configuration configuration;
    @Inject
    private DataManager dataManager;
    @Inject
    private MessageTools messageTools;

    // here we check secret code and issue token using OAuthTokenIssuer
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get(@RequestParam("code") String authCode) {
        // obtain system session to be able to call middleware services
        WebAuthConfig webAuthConfig = configuration.getConfig(WebAuthConfig.class);
        UserSession systemSession;
        try {
            systemSession = loginService.getSystemSession(webAuthConfig.getTrustedClientPassword());
        } catch (LoginException e) {
            throw new RuntimeException("Error during system auth");
        }

        // set security context
        AppContext.setSecurityContext(new SecurityContext(systemSession));
        try {
            // find coupon with code
            LoadContext<Coupon> loadContext = LoadContext.create(Coupon.class)
                    .setQuery(LoadContext.createQuery("select c from demo$Coupon c where c.code = :code")
                            .setParameter("code", authCode));

            if (dataManager.load(loadContext) == null) {
                // if coupon is not found - code is incorrect
                return new ResponseEntity<>(new ErrorInfo("invalid_grant", "Bad credentials"), HttpStatus.BAD_REQUEST);
            }

            // generate token for "promo-user"
            OAuthTokenIssuer.OAuth2AccessTokenResult tokenResult =
                    oAuthTokenIssuer.issueToken("promo-user", messageTools.getDefaultLocale(), Collections.emptyMap());
            OAuth2AccessToken accessToken = tokenResult.getAccessToken();

            // set security HTTP headers to prevent browser caching of security token
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CACHE_CONTROL, "no-store");
            headers.set(HttpHeaders.PRAGMA, "no-cache");
            return new ResponseEntity<>(accessToken, headers, HttpStatus.OK);
        } finally {
            // clean up security context
            AppContext.setSecurityContext(null);
        }
    }

    // POJO for JSON error messages
    public static class ErrorInfo implements Serializable {
        private String error;
        private String error_description;

        public ErrorInfo(String error, String error_description) {
            this.error = error;
            this.error_description = error_description;
        }

        public String getError() {
            return error;
        }

        public String getError_description() {
            return error_description;
        }
    }
}