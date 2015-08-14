/*
 * Copyright (c) 2012 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */


import org.gradle.api.DefaultTask
import org.gradle.api.InvalidUserDataException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.FileCollection
import org.gradle.api.file.FileVisitDetails
import org.gradle.api.tasks.*
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node

import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

class DocPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task([type: Copy], 'prepareStyleSheets') {
            File xslDir = new File(project.docToolsDir, 'xsl')
            into new File(project.buildDir, 'xsl')
            from(xslDir) {
                include '*.xsl'
            }
            from(project.zipTree(project.configurations.prepareStyleSheets.singleFile)) {
                // Remove the prefix
                eachFile { fcd -> fcd.path = fcd.path.replaceFirst('^docbook-xsl-[0-9\\.]+/', '') }
            }
        }
    }
}

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
        project.exec {
            workingDir "content/$docName/adoc/$docLang"
            if (System.getProperty('os.name').toLowerCase().contains('windows')) {
                commandLine 'cmd', '/c'
                args 'asciidoctor', "${docName}.adoc", '-D', "$project.buildDir/$docName/$docLang/html-single"
            } else {
                commandLine 'sh'
                args '-c', "asciidoctor ${docName}.adoc -D $project.buildDir/$docName/$docLang/html-single"
            }
        }

        project.copy {
            from "content/$docName/img"
            into "$project.buildDir/$docName/$docLang/html-single/img"
        }
    }
}

class Asciidoc2Docbook extends DefaultTask {
    String docName
    String docLang

    @InputDirectory
    File getSrcDir() {
        return project.file("content/$docName/adoc/$docLang")
    }

    @OutputDirectory
    File getDstDir() {
        return project.file("$project.buildDir/$docName/$docLang/docbook")
    }

    @TaskAction
    def transform() {
        project.exec {
            workingDir "content/$docName/adoc/$docLang"
            if (System.getProperty('os.name').toLowerCase().contains('windows')) {
                commandLine 'cmd', '/c'
                args 'asciidoctor', "${docName}.adoc", '-b', 'docbook45', '-D', "$project.buildDir/$docName/$docLang/docbook"
            } else {
                commandLine 'sh'
                args '-c', "asciidoctor ${docName}.adoc -b docbook45 -D $project.buildDir/$docName/$docLang/docbook"
            }
        }
    }
}

class DocTask extends DefaultTask {

    File preprocessXml(FileCollection classpath, File srcFile, File dstDir) {
        XIncludeAwareXmlProvider provider = new XIncludeAwareXmlProvider(classpath)
        provider.parse(srcFile)
        File dstFile = new File(dstDir, srcFile.name)
        dstFile.parentFile.mkdirs()
        provider.write(dstFile)
        return dstFile
    }
}

class Docbook2Xhtml extends DocTask {

    String docName
    String docLang

    File sourceFile
    File destFile
    FileCollection resources
    File tmpDir = new File(project.buildDir, "tmp/doc")
    String stylesheetName = 'html-single.xsl'

    @InputFiles
    FileCollection classpath = project.configurations.buildDoc

    @InputFile
    File getSrcFile() {
        if (sourceFile) sourceFile
        else project.file("content/$docName/xml/$docLang/${docName}.xml")
    }

    @InputDirectory
    File getSrcDir() {
        if (sourceFile) sourceFile.parentFile
        else project.file("content/$docName/xml/$docLang")
    }

    @InputDirectory
    File stylesheetsDir = new File(project.buildDir, 'xsl')

    @InputFiles
    FileCollection getRes() {
        if (resources) resources
        else {
            def res = project.fileTree("content/$docName") {
                include 'img/**/*.png'
                include 'img/**/*.jpg'
            }
            res += project.fileTree('tools/css') {
                include '*.css'
                include '*.gif'
            }
            res += project.fileTree('tools/js') {
                include '*.js'
            }
            return res
        }
    }

    @InputDirectory
    File getSourceCodeDir() {
        project.file("content/$docName/source")
    }

    @InputDirectory
    File getVarDir() {
        project.file("content/$docName/var")
    }

    @OutputFile
    File getDstFile() {
        if (destFile) destFile
        else new File(project.buildDir, "$docName/$docLang/html-single/${docName}.html")
    }

    @OutputDirectory
    File getDstDir() {
        if (destFile) destFile.parentFile
        else new File(project.buildDir, "$docName/$docLang/html-single")
    }

    @TaskAction
    def transform() {
        File tmpFile = preprocessXml(classpath, getSrcFile(), tmpDir)

        ant.java(classname: 'org.apache.xalan.xslt.Process', failonerror: true, fork: true) {
            jvmarg(value: '-Xmx256m')
            arg(value: '-in')
            arg(value: tmpFile)
            arg(value: '-out')
            arg(value: getDstFile())
            arg(value: '-xsl')
            arg(value: new File(stylesheetsDir, stylesheetName))
            sysproperty(key: 'xslthl.config', value: new File("$stylesheetsDir/highlighting/xslthl-config.xml").toURI())
            sysproperty(key: 'org.apache.xerces.xni.parser.XMLParserConfiguration', value: 'org.apache.xerces.parsers.XIncludeParserConfiguration')
            classpath {
                path(path: classpath.asPath)
                path(location: new File(stylesheetsDir, 'extensions/xalan27.jar'))
            }
        }

        project.copy {
            into getDstFile().parentFile
            from getRes()
        }
    }
}


class DocBook2WebHelp extends DocTask {

    String docName
    String docLang

    File sourceFile;
    File destDir;
    File tmpDir = new File(project.buildDir, "tmp/doc")
    String stylesheetName = 'webhelp.xsl'

    @InputFiles
    FileCollection classpath = project.configurations.buildDoc

    @InputFile
    File getSrcFile() {
        if (sourceFile) sourceFile
        else project.file("content/$docName/xml/$docLang/${docName}.xml")
    }

    @InputDirectory
    File getSrcDir() {
        if (sourceFile) sourceFile.parentFile
        else project.file("content/$docName/xml/$docLang")
    }

    @OutputDirectory
    File getDstDir() {
        if (destDir) destDir
        else new File(project.buildDir, "$docName/$docLang/webhelp")
    }

    @InputDirectory
    File getImagesDir() {
        project.file("content/$docName/img")
    }

    @InputDirectory
    File getSourceCodeDir() {
        project.file("content/$docName/source")
    }

    @InputDirectory
    File getVarDir() {
        project.file("content/$docName/var")
    }

    @InputDirectory
    File stylesheetsDir = new File(project.buildDir, 'xsl')

    @InputDirectory
    File templateDir = project.file('tools/webhelp/template')

    @InputDirectory
    File searchDir = project.file('tools/webhelp/search')

    /**
     * Brand name, used for logo alt name.
     */
    @Input
    String brand = 'CUBA'

    /**
     * Makes xsl parameters overriding possible.
     */
    @Input @Optional
    Map<String, String> xslParameters;

    /**
     * List of files to be excluded from index.
     */
    @Input @Optional
    List exclude;


    @TaskAction
    def transform() {
        File tmpFile = preprocessXml(classpath, getSrcFile(), tmpDir)

        def parameters = [
                'webhelp.base.dir': getDstDir().path,
                'webhelp.indexer.language': docLang,
                'brandname': brand,
                'admon.graphics': '0',
                'generate.toc': 'book\ttoc,title'
        ];
        if (xslParameters) {
            xslParameters.each { entry ->
                parameters[entry.key] = entry.value
            }
        }

        File profiled = new File(getDstDir(), "x-included-profiled.xml");
        File styleXSL = new File(stylesheetsDir, stylesheetName);

        // We need Saxon for XSLT prcessing here
        FileCollection xsltClasspath = project.configurations.webHelpXslt
        def uris = xsltClasspath.collect {it.toURI().toURL()}
        def classloader = new URLClassLoader(uris as URL[], getClass().classLoader)
        def oldClassloader = Thread.currentThread().getContextClassLoader()
        Thread.currentThread().setContextClassLoader(classloader)
        try {
            new CubaXSLTProcessor(styleXSL).setParameters(parameters).transform(tmpFile, profiled)
        } finally {
            Thread.currentThread().setContextClassLoader(oldClassloader)
        }
        profiled.delete();

        // Building index using external indexer.
        def extensions = [
                "extensions/tagsoup-1.2.1.jar",
                "extensions/lucene-analyzers-3.0.0.jar",
                "extensions/lucene-core-3.0.0.jar"
        ];
        def jars = project.files(extensions.each { new  File(stylesheetsDir, it) })
        def indexer = project.configurations.webHelpIndexer.resolve();
        project.javaexec {
            main = "com.nexwave.nquindexer.IndexerMain"
            classpath project.files(jars, indexer)
            systemProperties = [
                    "htmlDir": getDstDir().path,
                    "indexerLanguage": docLang,
                    "htmlExtension": "html",
                    "doStem": "true", // js-Search does not work if its false.
                    "indexerExcludedFiles": exclude?.join(File.pathSeparator),
                    "org.xml.sax.driver": "org.ccil.cowan.tagsoup.Parser"
            ]
        }
        project.copy {
            from searchDir
            into new File(getDstDir(), "search")
            include("stemmers/${docLang}_stemmer.js")
            include("${docLang}*.props")
            include("default.props")
            include("punctuation.props")
        }

        if (templateDir != null) {
            project.copy {
                from templateDir
                into getDstDir()
            }
        }
        if (getImagesDir() != null) {
            project.copy {
                from getImagesDir().parentFile
                into getDstDir()
                include "${imagesDir.name}/**/*.png"
                include "${imagesDir.name}/**/*.jpg"
            }
        }

    }
}

class XIncludeAwareXmlProvider {
    final Iterable<java.io.File> classpath
    Document root

    XIncludeAwareXmlProvider(Iterable<File> classpath) {
        this.classpath = classpath
    }

    Element parse(File sourceFile) {
        System.setProperty("org.apache.xerces.xni.parser.XMLParserConfiguration",
                "org.apache.xerces.parsers.XIncludeParserConfiguration")

        // Set the thread context classloader to pick up the correct XML parser
        def uris = classpath.collect {it.toURI().toURL()}
        def classloader = new URLClassLoader(uris as URL[], getClass().classLoader)
        def oldClassloader = Thread.currentThread().getContextClassLoader()
        Thread.currentThread().setContextClassLoader(classloader)
        try {
            root = parseSourceFile(sourceFile)
        } finally {
            Thread.currentThread().setContextClassLoader(oldClassloader)
        }
        return root.documentElement
    }

    Node emptyDoc() {
        root = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    }

    void write(File destFile, boolean indent = false) {
        destFile.withOutputStream {OutputStream stream ->
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            if (indent) {
                transformer.setOutputProperty(OutputKeys.INDENT, "yes")
            }
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.MEDIA_TYPE, "text/xml");
            transformer.transform(new DOMSource(root), new StreamResult(stream));
        }
    }

    Document getDocument() {
        return root
    }

    private Document parseSourceFile(File sourceFile) {
        Class cls = Class.forName('com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl', true, Thread.currentThread().contextClassLoader)
        DocumentBuilderFactory factory = cls.newInstance()
        factory.setNamespaceAware(true)
        // Disable DTD loading because it is too slow
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        DocumentBuilder builder = factory.newDocumentBuilder()
        return builder.parse(sourceFile)
    }
}
