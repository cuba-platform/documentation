buildscript {
    // ...
    dependencies {
        classpath "com.haulmont.gradle:cuba-plugin:$cubaVersion"
        // Bintray upload plugin
        classpath "com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.0"
    }
}