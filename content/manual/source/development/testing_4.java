configure(coreModule) {
...
    task createTestDb(dependsOn: assemble, description: 'Creates local Postgres database for tests', type: CubaDbCreation) {
        dbms = 'postgres'
        dbName = 'sales_test'
        dbUser = 'cuba'
        dbPassword = 'cuba'
    }
