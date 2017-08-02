@RequestMapping(method = RequestMethod.GET)
public ResponseEntity get() {
    String loginUrl = getAsPrivilegedUser(() ->
            facebookService.getLoginUrl(getAppUrl(), OAuth2ResponseType.CODE_TOKEN)
    );

    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.LOCATION, loginUrl);
    return new ResponseEntity<>(headers, HttpStatus.FOUND);
}