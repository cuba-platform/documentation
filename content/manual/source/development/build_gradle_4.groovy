allprojects {
    configurations {
        all {
            resolutionStrategy.eachDependency { details ->
                if (details.requested.group == 'com.haulmont.cuba') {
                    details.useVersion 'X.Y-SNAPSHOT'
                }
            }
        }
    }
}