task buildWar(type: CubaWarBuilding) {
    webXmlPath = 'modules/web/web/WEB-INF/single-war-web.xml'
    appProperties = ['cuba.automaticDatabaseUpdate' : true]
    appHome = '${app.home}'
    doAfter = {
        copy {
            from 'jboss-deployment-structure.xml'
            into "${project.buildDir}/tmp/buildWar/META-INF/"
        }
    }
}