buildscript {
    ext.cubaVersion = '7.2.0'
    ext.kotlinVersion = '1.3.61' // add this line
    // ...
    dependencies {
        classpath "com.haulmont.gradle:cuba-plugin:$cubaVersion"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion" // add this line
        classpath "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"   // add this line
    }
}
// ...
apply(plugin: 'cuba')
apply(plugin: 'org.jetbrains.kotlin.jvm') // add this line
// ...
configure([globalModule, coreModule, webModule]) {
    // ...
    apply(plugin: 'cuba')
    apply(plugin: 'org.jetbrains.kotlin.jvm') // add this line

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion") // add this line
        compile("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion") // add this line
// ...