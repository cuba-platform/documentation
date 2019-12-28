configure([globalModule, coreModule, webModule]) {
    // ...
    dependencies {
        testCompile('org.jmockit:jmockit:1.48') // <1>
        testCompile('org.junit.jupiter:junit-jupiter-api:5.5.2')
        testCompile('org.junit.jupiter:junit-jupiter-engine:5.5.2')
        testCompile('org.junit.vintage:junit-vintage-engine:5.5.2')
    }
    // ...
    test {
        useJUnitPlatform()
        jvmArgumentProviders.add(new JmockitAgent(classpath)) // <2>
    }
}

class JmockitAgent implements CommandLineArgumentProvider { // <3>

    FileCollection classpath

    JmockitAgent(FileCollection classpath) {
        this.classpath = classpath
    }

    Iterable<String> asArguments() {
        def path = classpath.find { it.name.contains("jmockit") }.absolutePath
        ["-javaagent:${path}"]
    }
}