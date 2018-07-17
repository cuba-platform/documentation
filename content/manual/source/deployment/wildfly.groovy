task buildWar(type: CubaWarBuilding) {
    appProperties = ['cuba.automaticDatabaseUpdate' : true]
    singleWar = false
    appHome = '${app.home}'
    doAfter = {
        copy {
            from 'jboss-deployment-structure.xml'
            into "${project.buildDir}/tmp/core/war/META-INF/"
        }
        copy {
            from 'jboss-deployment-structure.xml'
            into "${project.buildDir}/tmp/web/war/META-INF/"
        }
    }
}