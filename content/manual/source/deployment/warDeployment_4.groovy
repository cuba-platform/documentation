task buildWar(type: CubaWarBuilding) {
    singleWar = false
    includeContextXml = true
    includeJdbcDriver = true
    appProperties = ['cuba.automaticDatabaseUpdate': true]
    coreContextXmlPath = 'modules/core/web/META-INF/production-context.xml'
}