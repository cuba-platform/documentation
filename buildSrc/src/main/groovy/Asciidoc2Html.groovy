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

    @InputDirectory
    File getSourceCodeDir() {
        return project.file("content/$docName/source")
    }

    @InputDirectory
    File getImagesDir() {
        return project.file("content/$docName/img")
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

        postProcessHtml()
    }

    def postProcessHtml() {
        def filePath = "$project.buildDir/$docName/$docLang/html-single/${docName}.html"
        def file = new File(filePath);

        def doc = Jsoup.parse(file, 'utf-8', '')
        def toc = doc.select("div[id=toc]").first()

        toc.select("a").each {
            def text = it.text()
            text = text.replaceAll("^[\\d\\.]+", '')
            it.text(text)
        }


        doc.select("a").each {
            final URI uri = new URI(it.attr("href"));
            if (uri.isAbsolute()) {
                it.attr("target", "_blank")
            }
        }

        def hideCaption = docLang == 'ru' ? 'Скрыть панель' : 'Hide panel';

        def treeControl = toc.prependElement("div")
        treeControl.attr("id", "treecontrol")

        doc.body().append("<script type=\"text/javascript\" src=\"js/jquery-1.11.1.min.js\"/>\n" +
                "<script type=\"text/javascript\" src=\"js/jquery.treeview.js\"/>\n" +
                "<script type=\"text/javascript\" src=\"js/jquery.nearest.min.js\"/>\n" +
                "<script type=\"text/javascript\" src=\"js/toc-controller.js\"/>\n")

        if (docName == 'polymer') {
            doc.body().append("<script type=\"text/javascript\" src=\"js/polymer-polyfill/webcomponents-loader.js\"/>\n")
        }

        doc.body().append("<a href=\"#\" id=\"toc-position-marker\">. . .</a>");

        doc.head().prepend("<link rel=\"stylesheet\" href=\"styles/jquery.treeview.css\"/>")

        doc.head().append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=0.6\">")

        if (project.hasProperty('canonicalVer')) {
            def url = "${project.docHome}/${docName}-${project.canonicalVer}"
            if (docLang != 'en') {
                url += "-${docLang}"
            }
            doc.head().append("<link rel=\"canonical\" href=\"${url}/${docName}.html\">")
        }

        doc.body().append("<script type=\"text/javascript\">(function(g,a,i){(a[i]=a[i]||[]).push(function(){try{a.yaCounter31327533=new Ya.Metrika({id:31327533,clickmap:true,trackLinks:true,accurateTrackBounce:true,webvisor:true,trackHash:true})}catch(c){}});var h=g.getElementsByTagName(\"script\")[0],b=g.createElement(\"script\"),e=function(){h.parentNode.insertBefore(b,h)};b.type=\"text/javascript\";b.async=true;b.src=\"https://mc.yandex.ru/metrika/watch.js\";if(a.opera==\"[object Opera]\"){g.addEventListener(\"DOMContentLoaded\",e,false)}else{e()}})(document,window,\"yandex_metrika_callbacks\");</script> \n" +
                "  <noscript><div><img alt=\"\" style=\"position:absolute; left:-9999px;\" src=\"https://mc.yandex.ru/watch/31327533\"></div></noscript> \n" +
                "  <script>(function(d,e,j,h,f,c,b){d.GoogleAnalyticsObject=f;d[f]=d[f]||function(){(d[f].q=d[f].q||[]).push(arguments)},d[f].l=1*new Date();c=e.createElement(j),b=e.getElementsByTagName(j)[0];c.async=1;c.src=h;b.parentNode.insertBefore(c,b)})(window,document,\"script\",\"//www.google-analytics.com/analytics.js\",\"ga\");ga(\"create\",\"UA-48250949-2\",\"auto\",{allowLinker:true});ga(\"require\",\"linker\");ga(\"linker:autoLink\",[\"www.cuba-platform.com\"]);ga(\"require\",\"displayfeatures\");ga(\"send\",\"pageview\");</script>")

        file.write(doc.toString(), 'utf-8')
    }
}