// setter injection

protected GlobalConfig globalConfig;

@Inject
public void setConfiguration(Configuration configuration) {
    this.globalConfig = configuration.getConfig(GlobalConfig.class);
}