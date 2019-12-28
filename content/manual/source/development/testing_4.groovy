configure(coreModule) {
    // ...
    task createTestDb(dependsOn: assembleDbScripts, type: CubaDbCreation) {
        dbms = 'postgres'
        host = 'localhost'
        dbName = 'demo_test'
        dbUser = 'cuba'
        dbPassword = 'cuba'
    }
