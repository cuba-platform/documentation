@RequestMapping(method = RequestMethod.POST, value = "login")
public ResponseEntity<OAuth2AccessToken> login(@RequestParam("code") String code) {
    User user = getAsPrivilegedUser(() -> {
        FacebookUserData userData = facebookService.getUserData(getAppUrl(), code);

        return socialRegistrationService.findOrRegisterUser(
            userData.getId(), userData.getEmail(), userData.getName());
    });

    OAuth2AccessTokenResult tokenResult = oAuthTokenIssuer.issueToken(user.getLogin(),
            messageTools.getDefaultLocale(), Collections.emptyMap());

    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.CACHE_CONTROL, "no-store");
    headers.set(HttpHeaders.PRAGMA, "no-cache");
    return new ResponseEntity<>(tokenResult.getAccessToken(), headers, HttpStatus.OK);
}