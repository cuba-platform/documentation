import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*
import org.jsoup.Jsoup

class PostProcessDocHtml extends DefaultTask {

    String docName
    String docLang

    @TaskAction
    def postProcess() {
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

        doc.body().append("<a href=\"#\" id=\"toc-position-marker\">. . .</a>");

        doc.head().prepend("<link rel=\"stylesheet\" href=\"styles/jquery.treeview.css\"/>")

        doc.head().append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=0.6\">")

        doc.body().append("<script type=\"text/javascript\">(function(g,a,i){(a[i]=a[i]||[]).push(function(){try{a.yaCounter31327533=new Ya.Metrika({id:31327533,clickmap:true,trackLinks:true,accurateTrackBounce:true,webvisor:true,trackHash:true})}catch(c){}});var h=g.getElementsByTagName(\"script\")[0],b=g.createElement(\"script\"),e=function(){h.parentNode.insertBefore(b,h)};b.type=\"text/javascript\";b.async=true;b.src=\"https://mc.yandex.ru/metrika/watch.js\";if(a.opera==\"[object Opera]\"){g.addEventListener(\"DOMContentLoaded\",e,false)}else{e()}})(document,window,\"yandex_metrika_callbacks\");</script> \n" +
                "  <noscript><div><img alt=\"\" style=\"position:absolute; left:-9999px;\" src=\"https://mc.yandex.ru/watch/31327533\"></div></noscript> \n" +
                "  <script>(function(d,e,j,h,f,c,b){d.GoogleAnalyticsObject=f;d[f]=d[f]||function(){(d[f].q=d[f].q||[]).push(arguments)},d[f].l=1*new Date();c=e.createElement(j),b=e.getElementsByTagName(j)[0];c.async=1;c.src=h;b.parentNode.insertBefore(c,b)})(window,document,\"script\",\"//www.google-analytics.com/analytics.js\",\"ga\");ga(\"create\",\"UA-48250949-2\",\"auto\",{allowLinker:true});ga(\"require\",\"linker\");ga(\"linker:autoLink\",[\"www.cuba-platform.com\"]);ga(\"require\",\"displayfeatures\");ga(\"send\",\"pageview\");</script>")

        file.write(doc.toString(), 'utf-8')
    }
}