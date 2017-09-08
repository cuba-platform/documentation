buildscript {
    ...
    repositories {
        maven {
            url 'http://repo.company.com/nexus/content/groups/work' // repository containing CUBA and your own artifacts
            credentials {
                username(rootProject.hasProperty('repoUser') ? rootProject['repoUser'] : 'admin')
                password(rootProject.hasProperty('repoPass') ? rootProject['repoPass'] : 'admin123')
            }
        }
...
cuba {
    ...
    uploadRepository {
        url = 'http://repo.company.com/nexus/content/repositories/snapshots' // repository for uploading your artifacts
        user = 'admin'
        password = 'admin123'
    }
}