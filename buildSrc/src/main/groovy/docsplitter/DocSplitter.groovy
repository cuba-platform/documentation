package docsplitter

import java.util.regex.Pattern

class DocSplitter {

    String docName
    String docLang
    File dstDir

    private File srcDir

    class Context {

    }

    class Section {
        String name
        Section parent
        List<Section> children
        int level
        List<String> lines

        @Override
        String toString() {
            return "Section{name: $name, level: $level}"
        }
    }

    void process() {
        if (!dstDir.exists()) {
            dstDir.mkdirs()
        }
        println "Splitting document $docName $docLang to $dstDir"

        def srcFile = new File("content/$docName/adoc/$docLang/${docName}.adoc")
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("File $srcFile not found")
        }
        srcDir = srcFile.parentFile

        def lines = processIncludes(srcFile)
//        def dstFile = new File(dstDir, 'dst.adoc')
//        if (dstFile.exists()) {
//            dstFile.delete()
//        }
//        lines.each {
//            dstFile << it + '\n'
//        }

        List<Section> sections = splitToSections(lines)

        sections.eachWithIndex { section, idx ->
            section.parent = sections.subList(0, idx).reverse().find { s -> s.level == section.level - 1 }
        }

        sections.each { section ->
            section.children = sections.findAll { s -> s.parent == section }
        }

        println sections

        writeSection(sections[0], dstDir)

    }

    private void writeSection(Section section, File dir) {
        def dstFile = new File(dir, section.name + '.adoc')
        if (dstFile.exists()) {
            dstFile.delete()
        }

        if (section.level > 2) {
            dstFile << ":sourcesdir: ${'../'.multiply(section.level)}source\n\n"
        }

        section.lines.each {
            dstFile << it + '\n'
        }

        if (!section.children.isEmpty()) {
            File childrenDir = section.level == 1 ? dir : new File(dir, section.name)
            childrenDir.mkdirs()
            section.children.each { childSec ->
                writeSection(childSec, childrenDir)

                def dirName = section.level == 1 ? "" : section.name + '/'
                dstFile << "include::${dirName}${childSec.name}.adoc[]\n\n"
            }
        }
    }

    private Pattern HEADER_PATTERN = ~/^(=+) +.+/
    private Pattern NAME_PATTERN = ~/^\[\[(\S+)]]/

    private List<Section> splitToSections(List<String> lines) {
        List<Section> sections = []
        Section current = null
        int startIdx = 0
        for (int i = 0; i < lines.size(); i++) {
            def matcher = HEADER_PATTERN.matcher(lines[i])
            if (matcher.matches()) {
                int level = matcher.group(1).length()
                int idx = adjustIndex(lines, i)
                if (current != null) {
                    current.lines = lines.subList(startIdx, idx)
                }
                startIdx = idx
                String name = current == null ? docName : findName(lines, idx)
                current = new Section(level: level, name: name)
                sections.add(current)
            }
        }
        current.lines = lines.subList(startIdx, lines.size())
        sections
    }

    String findName(List<String> lines, int idx) {
        for (int i = idx; i < lines.size(); i++) {
            def matcher = NAME_PATTERN.matcher(lines[i])
            if (matcher.matches()) {
                return matcher.group(1)
            }
        }
        null
    }

    private int adjustIndex(List<String> lines, int idx) {
        for (int i = idx; i >= 0; i--) {
            if (lines[i].trim().isEmpty()) {
                return i + 1
            }
        }
        return idx
    }

    List<String> processIncludes(File file) {
        println "Processing includes in $file"
        def result = []
        def lines = file.readLines('UTF-8')
        lines.each { line ->
            def matcher = line =~ /include::(.+)\.adoc\[]/
            if (matcher.matches()) {
                String incFileName = matcher.group(1)
                def incLines = processIncludes(new File(srcDir, incFileName + '.adoc'))
                result.addAll(incLines)
            } else {
                result.add(line)
            }
        }
        result
    }
}
