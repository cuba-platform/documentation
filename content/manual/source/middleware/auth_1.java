@Inject
protected Authentication authentication;
...
authentication.begin();
try {
    // authenticated code
} finally {
    authentication.end();
}