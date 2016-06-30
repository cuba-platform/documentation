task buildWar(type: CubaWarBuilding) {
    appHome = './app_home'
    singleWar = false
    includeContextXml = true
    includeJdbcDriver = true
    appProperties = ['cuba.automaticDatabaseUpdate': true]
}