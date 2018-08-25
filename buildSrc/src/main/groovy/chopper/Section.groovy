package chopper

import org.apache.commons.lang3.StringEscapeUtils
import org.jsoup.nodes.Element

class Section {

    public static final String UTF_8 = 'UTF-8'

    private Element element
    private int level
    Section parent
    List<Section> children = new ArrayList<>()
    List<String> ids = new ArrayList()

    private String id
    Element headerEl
    String title
    String pageTitle
    String tocItem

    private final def SECTION_NUM_PATTERN = ~/(\d+\.)+ /

    Section(Element element, int level, Section parent) {
        this.parent = parent
        this.level = level
        this.element = element
    }

    def parse() {
        if (parent == null) {
            id = "index"
        } else {
            def hEls = element.getElementsByTag("h${level + 1}")
            if (hEls.isEmpty())
                throw new IllegalStateException("'h${level + 1}' element is not found in section '${getBeginning()}'")
            this.headerEl = hEls[0]

            def id = headerEl.attr("id")
            if (id.isEmpty())
                throw new IllegalStateException("No 'id' attribute in '${getBeginning()}'")
            this.id = id

            title = headerEl.ownText()
            tocItem = SECTION_NUM_PATTERN.matcher(headerEl.ownText()).replaceFirst("")
            pageTitle = tocItem + " - " + getHierarchy()[0].pageTitle

            def ancorEls = headerEl.getElementsByClass("anchor")
            if (!ancorEls.isEmpty()) {
                def href = ancorEls[0].attr("href")
                if (href.startsWith("#") && href.substring(1) == id) {
                    ancorEls[0].remove()
                }
            }
        }

        def nextLevel = this.level + 1
        def sectElements = element.getElementsByClass("sect$nextLevel")
        for (sectEl in sectElements) {
            def sect = new Section(sectEl, nextLevel, this)
            children.add(sect)
            sect.parse()
            sectEl.remove()
        }

        ids.addAll(element.getElementsByAttribute("id").collect { it.attr("id") })
    }

    private String getBeginning() {
        element.outerHtml().substring(0, 100) + "..."
    }

    private String getHtmlContent(Context context) {
        def template = (parent == null) ? "index.html" : "page.html"
        def html = new File(context.etcDir, template).getText(UTF_8)
        def next = getNext()

        def vars = new Properties(context.vars)
        vars.setProperty("pageTitle", pageTitle)
        vars.setProperty("toc", createToc())
        vars.setProperty("content", (parent == null) ? headerEl.outerHtml() : element.outerHtml())
        vars.setProperty("next.href", next.id + ".html")
        vars.setProperty("next.text", next.title)

        def srcDoc = id + '.adoc'
        if (level > 1) {
            def p = this
            while (p.level > 1) {
                p = p.parent
                srcDoc = p.id + '/' + srcDoc
            }
        }
        def gitBranch = context.vars['gitBranch']
        def docName = context.vars['docName']
        def docLang = context.locale == '' ? 'en' : context.locale
        vars.setProperty("github-link",
                "https://github.com/cuba-platform/documentation/blob/$gitBranch/content/$docName/adoc/$docLang/$srcDoc")

        for (name in vars.stringPropertyNames()) {
            if (name == 'scripts' && Boolean.valueOf(System.getProperty('noScripts'))) {
                html = html.replace('{{scripts}}', '')
            } else {

                def property = vars.getProperty(name)

                if (name == 'scripts' && vars.getProperty('docName') == 'polymer') {
                    property += '<script type="text/javascript" src="./js/polymer-polyfill/webcomponents-loader.js"></script>'
                    property += '<script type="text/javascript" src="./js/highlight-js/highlight.min.js"></script>'
                    property += '<script type="text/javascript" src="./js/highlight-js/highlight-init.js"></script>'
                    property += '<link rel="stylesheet" href="./js/highlight-js/styles/github.min.css"></link>'
                }

                if (name == 'scripts') {
                    def anchorPath = context.etcDir.getPath() + "/anchors"
                    def anchorScript = new File(anchorPath, 'anchors.js').getText(UTF_8)
                    def anchorCss = new File(anchorPath, 'anchors.css').getText(UTF_8)

                    property += "<script>${anchorScript}</script>"
                    property += "<style>${anchorCss}</style>"
                }

                html = html.replace("{{" + name + "}}", property)
            }
        }
        return html
    }

    private Section getNext() {
        if (!children.isEmpty())
            return children[0]
        else {
            def hierarchy = getHierarchy().reverse()
            if (hierarchy.size() > 1) {
                for (int i = 1; i < hierarchy.size(); i++) {
                    def p = hierarchy[i]
                    def c = hierarchy[i - 1]
                    if (!c.equals(p.children.last())) {
                        def indexOfC = p.children.indexOf(c)
                        return p.children[indexOfC + 1]
                    }
                }
            }
            return hierarchy.last()
        }
    }

    private String printTocItem(List<Section> hierarchy) {
        def sb = new StringBuilder()

        def inHierarchy = hierarchy.contains(this)
        def isSelected = this == hierarchy.last()

        sb.append("\n<li class='toc-item");
        if (isSelected)
            sb.append(" toc-selected-item");
        sb.append("'>${getTocMarker(this, inHierarchy)}${getTocA(this, isSelected, inHierarchy)}");
        if (inHierarchy) {
            sb.append("\n<ul>")
            for (child in children) {
                sb.append(child.printTocItem(hierarchy))
            }
            sb.append("\n</ul>")
        }
        sb.append("\n</li>")

        return sb.toString()
    }

    String createToc() {
        def sb = new StringBuilder()

        sb.append("\n<ul class='toc-root'>")

        def hierarchy = getHierarchy()
        def root = hierarchy[0]

        sb.append("\n<li>${getTocA(root, false, false)}</li>");

        for (item in root.children) {
            sb.append(item.printTocItem(hierarchy))
        }

        sb.append("\n</ul>")
        return sb.toString()
    }

    private String getTocMarker(Section section, Boolean open) {
        def sb = new StringBuilder()
        sb.append("<div class='toc-marker")
        if (!section.children.isEmpty()) {
            if (open)
                sb.append(" open")
            else
                sb.append(" closed")
        }
        sb.append("'></div>")
        return sb.toString()
    }

    private String getTocA(Section section, Boolean active, Boolean open) {
        def sb = new StringBuilder()
        sb.append("<div class='toc-link")
        if (open)
            sb.append(" open")
        sb.append("'><a href='${section.id}.html'")
        if (active)
            sb.append(" class='toc-highlighted'")
        sb.append(">${section.tocItem}</a></div>")
        return sb.toString()
    }

    private List<Section> getHierarchy() {
        List<Section> parents = new ArrayList<>()
        def p = parent
        while (p != null) {
            parents.add(p)
            p = p.parent
        }
        parents.reverse(true)
        parents.add(this)
        return parents
    }

    def write(Context context) {
        replaceLinks(context.links)

        def content = getHtmlContent(context)

        def fileName = id + ".html"
        def file = new File(context.outputDir, fileName)
        file.write(content, UTF_8)

        indexFile(element.text(), fileName, context)

        for (childSect in children) {
            childSect.write(context)
        }
    }

    def replaceLinks(Map<String, Section> links) {
        def aElements = element.getElementsByTag("a")
        for (aEl in aElements) {
            def href = aEl.attr("href")
            if (href.startsWith("#")) {
                def ref = href.substring(1)
                def section = links[ref]
                if (section == null) {
                    println("Unknown link: $href")
                    continue
                }
                if (section != this) {
                    def newRef = (ref == section.id) ? "${section.id}.html" : "${section.id}.html#$ref"
                    aEl.attr("href", newRef)
                }
            }
        }
    }

    private def indexFile(String contents, String fileName, Context context) {
        String captionPath
        def captionName = tocItem
        def hierarchy = getHierarchy()
        if (hierarchy.size() == 1) {
            captionPath = ""
        } else {
            def sep = context.vars.getProperty("pathSeparator")
            captionPath = hierarchy.subList(1, hierarchy.size() - 1).collect { it.tocItem }.join(" $sep ")
            if (!captionPath.isEmpty())
                captionPath += " $sep"
        }

        def text = contents.replace("\n", " ").replace("\r", " ").replace("\t", " ").replaceAll(/\s+/, " ")

        context.indexContent.append(fileName).append("\t")
        context.indexContent.append(StringEscapeUtils.escapeHtml4(captionPath)).append("\t")
        context.indexContent.append(StringEscapeUtils.escapeHtml4(captionName)).append("\t")
        context.indexContent.append(text).append("\n")
    }


    @Override
    public String toString() {
        return "Section{" +
                "id='" + id + '\'' +
                '}';
    }
}
