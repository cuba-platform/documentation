import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

class SetupTomcat extends DefaultTask {

    @OutputDirectory
    def dir = "$project.rootDir/deploy/tomcat"

    SetupTomcat() {
        setDescription('Sets up local Tomcat')
        setGroup('Deployment')
    }

    @TaskAction
    def setupTomcat() {
        project.configurations.tomcat.files.each { dep ->
            project.copy {
                from project.zipTree(dep.absolutePath)
                into "$project.buildDir/tomcat_tmp"
            }
        }
        new File("$project.buildDir/tomcat_tmp").eachDirMatch(~/apache-tomcat-.*/) { File dir ->
            project.copy {
                from dir
                into this.dir
                exclude '**/webapps/*'
                exclude '**/work/*'
                exclude '**/temp/*'
            }
        }
        project.delete("$project.buildDir/tomcat_tmp")

        project.copy {
            from "$project.rootDir/tools/tomcat"
            into dir
        }

        ant.chmod(osfamily: 'unix', perm: 'a+x') {
            fileset(dir: "$dir/bin", includes: '*.sh')
        }
    }
}
