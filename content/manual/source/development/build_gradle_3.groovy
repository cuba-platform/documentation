configure(coreModule) {
    ...
    entitiesEnhancing {
        main {
            enabled = true
            persistenceConfig = 'custom-persistence.xml'
        }
        test {
            enabled = true
            persistenceConfig = 'test-persistence.xml'
        }
    }
}