task buildWar(type: CubaWarBuilding) {
    appProperties = ['cuba.automaticDatabaseUpdate' : true]
    singleWar = false
    doAfter = {
        copy {
            from 'jboss-deployment-structure.xml'
            into "${project.buildDir}/tmp/buildWar/core/war/META-INF/"
        }
        copy {
            from 'jboss-deployment-structure.xml'
            into "${project.buildDir}/tmp/buildWar/web/war/META-INF/"
        }
    }
}