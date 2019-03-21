task buildWar(type: CubaWarBuilding) {
    appProperties = ['cuba.automaticDatabaseUpdate': true, 'cuba.logDir': '${catalina.base}/logs']
    appHome = '..'
    includeContextXml = true
    webXmlPath = 'modules/web/web/WEB-INF/single-war-web.xml'
    includeJdbcDriver = true
    hsqlInProcess = true
}