task buildWar(type: CubaWarBuilding) {
    appHome = '${app.home}'
    singleWar = true
    includeContextXml = true
    includeJdbcDriver = true
    appProperties = ['cuba.automaticDatabaseUpdate': true]
    webXmlPath = 'modules/web/web/WEB-INF/single-war-web.xml'
    coreContextXmlPath = 'modules/core/web/META-INF/war-context.xml'
}