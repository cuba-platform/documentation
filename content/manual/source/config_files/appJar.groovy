configure(coreModule) {
    //...
    task deploy(dependsOn: assemble, type: CubaDeployment) {
        appName = 'app-core'
        appJars('app-global', 'app-core', 'javamelody-core')
    }
    //...
}