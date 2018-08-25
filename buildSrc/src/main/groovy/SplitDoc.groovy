import docsplitter.DocSplitter
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 *
 * @author Konstantin Krivopustov
 */
class SplitDoc extends DefaultTask {

    String docName
    String docLang
    String dstDirName

    @TaskAction
    def splitDoc() {
        File dstDir = new File(dstDirName)

        def splitter = new DocSplitter(docName: docName, docLang: docLang, dstDir: dstDir)
        splitter.process()

    }
}
