configure([globalModule, coreModule, webModule]) {
    apply(plugin: 'java')
    apply(plugin: 'maven')
    apply(plugin: 'cuba')

    dependencies {
        testCompile('org.jmockit:jmockit:1.39') // add mocking framework here
        testCompile('junit:junit:4.12')
    }

    // ...