task buildWar(type: CubaWarBuilding) {
    includeJdbcDriver = true
    includeContextXml = true
    appProperties = ['cuba.automaticDatabaseUpdate': true,
                     'cuba.logDir'                 : '${catalina.base}/logs']
    webXmlPath = 'modules/web/web/WEB-INF/single-war-web.xml'
    appHome = '..'
    coreContextXmlPath = 'modules/core/web/META-INF/war-context.xml'
}