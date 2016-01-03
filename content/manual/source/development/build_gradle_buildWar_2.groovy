task buildWar(type: CubaWarBuilding) {
    coreProject = project(':app-core')
    webProject = project(':app-web')
    appName = 'app'
    appHome = '..'
    appProperties = ['cuba.automaticDatabaseUpdate': 'true']
    singleWar = false
}