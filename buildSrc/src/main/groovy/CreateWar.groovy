import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction;

/**
 * @author Konstantin Krivopustov
 */
public class CreateWar extends DefaultTask {

    String docName
    String docLang
    String docVer

    @InputDirectory
    File getSrcDir() {
        return new File("${project.buildDir}/$docName/$docLang/html")
    }

    @InputFile
    File getSrcFile() {
        return new File("${project.buildDir}/$docName/$docLang/html-single/${docName}.html")
    }

    @OutputFile
    File getDstFile() {
        return new File("${project.buildDir}/war/$docName${getDocVersion()}${docLang == 'en' ? '' : ('-' + docLang)}.war")
    }

    @TaskAction
    def createWar() {
        def tmpDir = new File(project.buildDir, "tmp/war/$docName${getDocVersion()}${docLang == 'en' ? '' : ('-' + docLang)}")
        project.copy {
            from srcDir
            from srcFile
            into tmpDir
        }
        ant.jar(destfile: dstFile, basedir: tmpDir)
    }

    private getDocVersion() {
        docVer ? "-$docVer" : ''
    }
}
