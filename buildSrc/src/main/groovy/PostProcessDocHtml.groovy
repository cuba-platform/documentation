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

        def expandCaption = docLang == 'ru' ? 'Развернуть все' : 'Expand all';
        def collapseCaption = docLang == 'ru' ? 'Свернуть все' : 'Collapse all';
        def hideCaption = docLang == 'ru' ? 'Скрыть панель' : 'Hide panel';

        def treeControl = toc.prependElement("div")
        treeControl.attr("id", "treecontrol")

        treeControl.html("<a href=\"#\"> $collapseCaption </a>\n" +
                "<span class=\"separator-link\"> | </span>\n" +
                "<a href=\"#\"> $expandCaption </a>\n" +
                "<span class=\"separator-link\"> | </span>\n" +
                "<a href=\"#\" id=\"close-panel\" style=\"white-space: pre;\"> $hideCaption </a>")

        doc.body().append("<script type=\"text/javascript\" src=\"js/jquery-1.11.1.min.js\"/>\n" +
                "<script type=\"text/javascript\" src=\"js/jquery.treeview.js\"/>\n" +
                "<script type=\"text/javascript\" src=\"js/jquery.nearest.min.js\"/>\n" +
                "<script type=\"text/javascript\" src=\"js/toc-controller.js\"/>\n")

        doc.body().append("<a href=\"#\" id=\"toc-position-marker\">. . .</a>");

        doc.head().prepend("<link rel=\"stylesheet\" href=\"styles/jquery.treeview.css\"/>")

        file.write(doc.toString(), 'utf-8')
    }
}