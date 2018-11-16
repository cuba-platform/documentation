configure(coreModule) {
    // ...
    dependencies {
        // ...
        testRuntime(hsql)
        jdbc('org.postgresql:postgresql:9.4.1212')
        testRuntime('org.postgresql:postgresql:9.4.1212') // add this
    }