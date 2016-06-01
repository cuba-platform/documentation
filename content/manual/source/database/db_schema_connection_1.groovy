task createDb(dependsOn: assembleDbScripts, type: CubaDbCreation) {
    dbms = 'postgres'
    host = 'localhost'
    dbName = 'my_db'
    connectionParams = '?currentSchema=my_schema'
    dbUser = 'cuba'
    dbPassword = 'cuba'
}