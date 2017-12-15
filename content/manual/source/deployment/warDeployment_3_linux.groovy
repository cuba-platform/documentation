task buildWar(type: CubaWarBuilding) {
    appHome = '${catalina.base}/work'
    singleWar = true
    includeContextXml = true
    includeJdbcDriver = true
    appProperties = ['cuba.automaticDatabaseUpdate': true]
    webXmlPath = 'modules/web/web/WEB-INF/single-war-web.xml'
    coreContextXmlPath = 'modules/core/web/META-INF/war-context.xml'
    appProperties = [
        'cuba.automaticDatabaseUpdate': true,
        'cuba.webPort': 9999,
        'cuba.connectionUrlList': 'http://localhost:9999/app'
    ]
}