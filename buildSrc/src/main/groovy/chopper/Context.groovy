package chopper

class Context {
    File outputDir
    File etcDir
    Map<String, Section> links
    Properties vars
    StringBuilder indexContent

    Context(File outputDir, File etcDir, Map<String, Section> links, Properties vars, StringBuilder indexContent) {
        this.outputDir = outputDir
        this.etcDir = etcDir
        this.links = links
        this.vars = vars
        this.indexContent = indexContent
    }
}
