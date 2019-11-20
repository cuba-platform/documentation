task createDb(dependsOn: assembleDbScripts, description: 'Creates local database', type: CubaDbCreation) {
}

task updateDb(dependsOn: assembleDbScripts, description: 'Updates local database', type: CubaDbUpdate) {
}