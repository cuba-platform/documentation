task buildWar(type: CubaWarBuilding) {
    appHome = '${app.home}'
    singleWar = true
    includeContextXml = true
    includeJdbcDriver = true
    appProperties = ['cuba.automaticDatabaseUpdate': true]
}