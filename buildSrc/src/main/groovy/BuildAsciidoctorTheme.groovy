/*
 * Copyright (c) 2018 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*

class BuildAsciidoctorTheme extends DefaultTask {

    String themeName

    @TaskAction
    def generateTheme() {
        project.exec {
            workingDir "tools/asciidoctor-stylesheet-factory"
            if (System.getProperty('os.name').toLowerCase().contains('windows')) {
                commandLine 'cmd', '/c'
                args 'compass', "compile"
            } else {
                commandLine 'sh'
                args '-c', "compass compile"
            }
        }

        project.copy {
            from "tools/asciidoctor-stylesheet-factory/stylesheets/${themeName}.css"
            into "styles"
        }
    }
}