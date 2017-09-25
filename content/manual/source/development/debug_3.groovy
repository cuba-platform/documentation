task deploy.doLast {
    project.delete "$cuba.tomcat.dir/webapps/app/VAADIN/widgetsets"

    project.copy {
        from zipTree(configurations.debug.singleFile)
        into "$cuba.tomcat.dir/webapps/app"
    }
}