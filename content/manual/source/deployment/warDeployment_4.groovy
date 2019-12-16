task buildWar(type: CubaWarBuilding) {
    appHome = '${app.home}'
    singleWar = true
    includeContextXml = true
    includeJdbcDriver = true
    appProperties = ['cuba.automaticDatabaseUpdate': true]
    coreContextXmlPath = 'modules/core/web/META-INF/war-context.xml'
}