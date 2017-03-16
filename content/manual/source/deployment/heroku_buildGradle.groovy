task stage(dependsOn: ['setupTomcat', ':app-core:deploy', ':app-web:deploy']) {
    doLast {
        // replace context.xml with heroku-context.xml
        def src = new File('modules/core/web/META-INF/heroku-context.xml')
        def dst = new File('deploy/tomcat/webapps/app-core/META-INF/context.xml')
        dst.delete()
        dst << src.text

        // change port from 8080 to heroku $PORT
        def file = new File('deploy/tomcat/conf/server.xml')
        file.text = file.text.replace('8080', '${port.http}')

        // add local.app.properties for core application
        def coreConfDir = new File('deploy/tomcat/conf/app-core/')
        coreConfDir.mkdirs()
        def coreProperties = new File(coreConfDir, 'local.app.properties')
        coreProperties.text = '''
cuba.automaticDatabaseUpdate = true
        '''

        // rename deploy/tomcat/webapps/app to deploy/tomcat/webapps/ROOT
        def rootFolder = new File('deploy/tomcat/webapps/ROOT')
        if (rootFolder.exists()) {
            rootFolder.deleteDir()
        }

        def webAppDir = new File('deploy/tomcat/webapps/app')
        webAppDir.renameTo( new File(rootFolder) )

        // add local.app.properties for web application
        def webConfDir = new File('deploy/tomcat/conf/ROOT/')
        webConfDir.mkdirs()
        def webProperties = new File(webConfDir, 'local.app.properties')
        webProperties.text = '''
cuba.webContextName = /
        '''
    }
}