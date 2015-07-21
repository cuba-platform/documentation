@Inject
private ServerConfig serverConfig;

public void doSomething() {
    int timeout = serverConfig.getDefaultQueryTimeoutSec();
    ...
}