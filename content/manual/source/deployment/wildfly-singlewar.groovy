task buildWar(type: CubaWarBuilding) {
    webXmlPath = 'modules/web/web/WEB-INF/single-war-web.xml'
    appProperties = ['cuba.automaticDatabaseUpdate' : true]
    includeJdbcDriver = true
    appHome = '${app.home}'
    doAfter = {
        copy {
            from 'jboss-deployment-structure.xml'
            into "${project.buildDir}/tmp/war/META-INF/"
        }
    }
}