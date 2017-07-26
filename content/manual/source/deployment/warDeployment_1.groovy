task buildWar(type: CubaWarBuilding) {
    appHome = '${app.home}'
    appProperties = ['cuba.automaticDatabaseUpdate': 'true']
    singleWar = false
}