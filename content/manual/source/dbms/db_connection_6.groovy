task createDb(dependsOn: assembleDbScripts, description: 'Creates local database', type: CubaDbCreation) {
    dbms = 'hsql'
    host = 'localhost:9111'
    dbName = 'demo'
    dbUser = 'sa'
    dbPassword = ''
}

task updateDb(dependsOn: assembleDbScripts, description: 'Updates local database', type: CubaDbUpdate) {
    dbms = 'hsql'
    host = 'localhost:9111'
    dbName = 'demo'
    dbUser = 'sa'
    dbPassword = ''
}
