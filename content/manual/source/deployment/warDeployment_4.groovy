task buildWar(type: CubaWarBuilding) {
    singleWar = true
    includeContextXml = true
    includeJdbcDriver = true
    appProperties = ['cuba.automaticDatabaseUpdate': true]
    coreContextXmlPath = 'modules/core/web/META-INF/war-context.xml'
}