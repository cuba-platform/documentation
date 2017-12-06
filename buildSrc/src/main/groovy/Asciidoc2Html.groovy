import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*
import org.jsoup.Jsoup

class Asciidoc2Html extends DefaultTask {
    String docName
    String docLang

    @InputDirectory
    File getSrcDir() {
        return project.file("content/$docName/adoc/$docLang")
    }

    @OutputDirectory
    File getDstDir() {
        return project.file("$project.buildDir/$docName/$docLang/html-single")
    }

    @TaskAction
    def transform() {
        def dstDocDir = "$project.buildDir/$docName/$docLang/html-single"

        project.exec {
            workingDir "content/$docName/adoc/$docLang"


            if (System.getProperty('os.name').toLowerCase().contains('windows')) {
                commandLine 'cmd', '/c'

                args 'asciidoctor', "${docName}.adoc", '-D', dstDocDir
            } else {
                commandLine 'sh'
                args '-c', "asciidoctor ${docName}.adoc -D $dstDocDir"
            }
        }

        project.copy {
            from "content/$docName/img"
            into "$dstDocDir/img"
        }

        project.copy {
            from "images"
            into "$dstDocDir/img"
        }

        project.copy {
            from "styles"
            into "$dstDocDir/styles"
        }

        project.copy {
            from "js"
            into "$dstDocDir/js"
        }

        if (docName == 'polymer') {

            project.copy {
                include '**/*.html'
                include '**/*.js'
                exclude '**/node_modules/'
                exclude '**/gulpfile.js'
                from "polymer-build"
                into "$dstDocDir/html"
            }

        }
    }

    def postProcessHtml() {
        Jsoup.parse
    }
}