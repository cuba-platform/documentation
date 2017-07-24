repositories {
    // main repository containing CUBA artifacts
    maven {
        url 'https://repo.cuba-platform.com/content/groups/work'
        credentials {
            // ...
        }
    }
    // custom repository
    maven {
        url 'http://localhost:8081/repository/maven-snapshots'
    }
}