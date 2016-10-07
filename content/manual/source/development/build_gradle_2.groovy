configure(coreModule) {

    dependencies {
        // standard dependencies using variables defined in the script above
        compile(globalModule)
        provided(servletApi)
        jdbc(hsql)
        testRuntime(hsql)
        // add a custom repository-based dependency
        compile('com.company.foo:foo:1.0.0')
        // add a custom file-based dependency
        compile(files("${rootProject.projectDir}/lib/my-library-0.1.jar"))
        // add all JAR files in the directory to dependencies
        compile(fileTree(dir: 'libs', include: ['*.jar']))
    }
