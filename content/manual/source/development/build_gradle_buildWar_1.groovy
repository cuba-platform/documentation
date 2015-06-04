task buildWar(dependsOn: assemble, type: CubaWarBuilding) {
    appName = 'app'
    appHome = '${app.home}'
    appProperties = ['cuba.connectionUrlList': 'http://server/app-core']
}