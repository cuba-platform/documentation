int timeout = AppBeans.get(Configuration.class)
        .getConfig(ServerConfig.class)
        .getDefaultQueryTimeoutSec();