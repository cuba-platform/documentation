task buildUberJar(type: CubaUberJarBuilding) {
    singleJar = true
    coreJettyEnvPath = 'modules/core/web/META-INF/jetty-env.xml'
    appProperties = ['cuba.automaticDatabaseUpdate' : true]
    webJettyConfPath = 'jetty.xml'
}