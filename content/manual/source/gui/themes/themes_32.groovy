allprojects {
    group = 'com.haulmont.theme'
    version = '0.1'
}

apply(plugin: 'java')
apply(plugin: 'maven')

sourceSets {
    main {
        java {
            srcDir 'src'
        }
        resources {
            srcDir 'src'
        }
    }
}