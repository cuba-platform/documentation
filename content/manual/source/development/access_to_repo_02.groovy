buildscript {
    // ...
    repositories {
        // ...
        maven {
            url 'https://cuba-platform.bintray.com/premium'
            credentials {
                username(rootProject.hasProperty('premiumRepoUser') ?
                        rootProject['premiumRepoUser'] : System.getenv('CUBA_PREMIUM_USER'))
                password(rootProject.hasProperty('premiumRepoPass') ?
                        rootProject['premiumRepoPass'] : System.getenv('CUBA_PREMIUM_PASSWORD'))
            }
        }
    }