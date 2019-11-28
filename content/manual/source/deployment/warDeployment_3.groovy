task buildWar(type: CubaWarBuilding) {
    singleWar = false
    includeContextXml = true
    includeJdbcDriver = true
    appProperties = [
        'cuba.automaticDatabaseUpdate': true,
        'cuba.webPort': 9999,
        'cuba.connectionUrlList': 'http://localhost:9999/app-core'
    ]
}