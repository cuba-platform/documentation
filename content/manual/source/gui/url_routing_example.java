/*
 * UrlRouting usage example
 *
 * Screen is located in Web module
 */
@Inject 
private UrlRouting urlRouting;

// Real use case: reflect filter conditions to URL
protected void reflectFilter(Map<String, String> conditions) {
    urlRouting.replaceState(this, conditions);
}