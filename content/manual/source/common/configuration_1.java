// field injection

@Inject
protected Configuration configuration;
...
String tempDir = configuration.getConfig(GlobalConfig.class).getTempDir();