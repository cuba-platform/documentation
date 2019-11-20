task createDb(dependsOn: assembleDbScripts, type: CubaDbCreation) {
    dbms = 'postgres'
    host = 'localhost'
    dbName = 'demo'
    connectionParams = '?currentSchema=my_schema'
    dbUser = 'postgres'
    dbPassword = 'postgres'
}