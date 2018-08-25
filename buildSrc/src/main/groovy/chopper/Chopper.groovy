package chopper

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import java.nio.file.Files

class Chopper {

    private File input
    private String outputPath
    private File etcDir
    private String locale
    private Map<String, String> props

    Chopper(String inputFile, String outputDir, String etcPath, String locale, Map<String, String> props) {
        this.props = props
        this.input = new File(inputFile)
        this.locale = locale
        this.outputPath = outputDir
        this.etcDir = new File(etcPath)
    }

    void process() {
        def startTime = System.currentTimeMillis()

        def srcDir = input.parentFile
        def doc = Jsoup.parse(input, "UTF-8")

        def vars = loadProperties(etcDir, locale, doc)

        def headerEl = doc.getElementById("header")
        if (!headerEl)
            headerEl = doc.getElementsByTag("header").first()
        if (!headerEl)
            throw new IllegalStateException("Element with id='header' is not found")

        def contentEl = doc.getElementById("content")
        if (!contentEl)
            throw new IllegalStateException("Element with id='content' is not found")
        doc.getElementById("toc")?.remove()
        def rootSect = new Section(contentEl, 0, null)
        rootSect.headerEl = headerEl

        def docTitle = headerEl.getElementsByTag("h1").first()?.ownText()
        rootSect.title = docTitle ?: "Index"
        rootSect.pageTitle = rootSect.title
        rootSect.tocItem = vars.getProperty("home")
        rootSect.parse()

        def links = new HashMap<String, Section>()
        collectLinks(rootSect, links)

        def outputDir = prepareOutputDir(outputPath, rootSect, srcDir, etcDir, vars)

        def indexContent = new StringBuilder()

        rootSect.write(new Context(outputDir, etcDir, links, locale, vars, indexContent))

        def webInfDir = new File(outputDir, "WEB-INF")
        webInfDir.mkdir()
        new File(webInfDir, "index.txt").write(indexContent.toString(), 'UTF-8')

        println("Done in ${(System.currentTimeMillis() - startTime) / 1000}s")
    }

    private Properties loadProperties(File etcDir, String locale, Document doc) {
        def vars = new Properties()

        // load from file
        def file = new File(etcDir, (locale.isEmpty()) ? "var.properties" : "var_${locale}.properties")
        if (file.exists()) {
            file.withInputStream { is ->
                vars.load(new InputStreamReader(is, 'UTF-8'))
            }
        }

        // add passed properties
        props.entrySet().each { entry ->
            vars.setProperty(entry.key, entry.value)
        }

        // add some properties from the source HTML file
        def titleEl = doc.body().getElementsByTag("h1").first()
        if (titleEl != null && !vars.containsKey("title")) {
            vars.setProperty("title", titleEl.ownText());
        }
        def versionEl = doc.body().getElementById("revnumber")
        if (versionEl != null && !vars.containsKey("version")) {
            vars.setProperty("version", versionEl.ownText());
        }
        def copyrightEl = doc.body().getElementById("revremark")
        if (copyrightEl != null && !vars.containsKey("copyright")) {
            vars.setProperty("copyright", copyrightEl.ownText());
        }

        return vars
    }

    private void collectLinks(Section sect, Map<String, Section> links) {
        if (sect.parent != null) {
            for (id in sect.ids) {
                links.put(id, sect)
            }
        }
        for (childSect in sect.children) {
            collectLinks(childSect, links)
        }
    }

    private File prepareOutputDir(String outputDirArg, Section rootSect, File srcDir,
                                  File etcDir, Properties vars)  {
        def outputDir = new File(outputDirArg)

        if (outputDir.toPath().startsWith(srcDir.toPath())) {
            throw new IllegalArgumentException("outputDir cannot be inside inputDir")
        }

        if (outputDir.exists()) {
            outputDir.deleteDir()
        }
        outputDir.mkdir()

        srcDir.eachDir { File dir ->
            new AntBuilder().copy(todir: outputDirArg + "/" + dir.name) {
                fileset(dir: dir.absolutePath)
            }
        }

        def warTemplDir = new File(etcDir, "war")
        warTemplDir.eachFileRecurse { File file ->
            def relPath = warTemplDir.toPath().relativize(file.toPath())
            def dstFile = new File(outputDir, relPath.toString())
            if (file.isDirectory()) {
                dstFile.mkdir()
            } else {
                if (mayContainVars(file)) {
                    def text = file.getText('UTF-8')
                    vars.setProperty("toc", rootSect.createToc())
                    for (name in vars.stringPropertyNames()) {
                        text = text.replace("{{" + name + "}}", vars.getProperty(name))
                    }
                    dstFile.write(text, 'UTF-8')
                } else {
                    Files.copy(file.toPath(), dstFile.toPath())
                }
            }

        }

        return outputDir
    }

    private boolean mayContainVars(File file) {
        file.name.endsWith('.jsp') || file.name.endsWith('html') || file.name.endsWith('css')
    }
}
