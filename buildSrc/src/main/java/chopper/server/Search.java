package chopper.server;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Search {

    private static final int LEN = 70;

    private static class Sect {
        final String fileName;
        final String captionPath;
        final String captionName;
        final String text;
        final String lcText;

        public Sect(String fileName, String captionPath, String captionName, String text) {
            this.fileName = fileName;
            this.captionPath = captionPath;
            this.captionName = captionName;
            this.text = text;
            this.lcText = text.toLowerCase();
        }
    }

    private final List<Sect> sections = new ArrayList<>();

    public Search(InputStream inputStream) throws IOException {
        String index;
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            index = buffer.lines().collect(Collectors.joining("\n"));
        }
        inputStream.close();

        int idx = index.indexOf("\n");
        int start = 0;
        while (idx > -1) {
            String sectContent = index.substring(start, idx);
            String[] parts = sectContent.split("\t");

            sections.add(new Sect(parts[0], parts[1], parts[2], parts.length == 4 ? parts[3] : ""));

            start = idx + 1;
            idx = index.indexOf("\n", start);
        }
    }

    public List<SearchResult> search(String term) {
        List<SearchResult> results = new ArrayList<>();

        boolean ignoreCase = true;
        for (int i = 0; i < term.length(); i++) {
            if (Character.isLetter(term.charAt(i)) && Character.isUpperCase(term.charAt(i))) {
                ignoreCase = false;
                break;
            }
        }

        for (Sect sect : sections) {
            String text;
            if (ignoreCase) {
                term = term.toLowerCase();
                text = sect.lcText;
            } else {
                text = sect.text;
            }
            int idx = text.indexOf(term);
            if (idx > -1) {
                SearchResult result = new SearchResult(sect.fileName, sect.captionPath, sect.captionName);
                int start = 0;
                while (idx > -1) {
                    StringBuilder hit = new StringBuilder("<div class=\"hit-info\">");
                    hit.append(StringEscapeUtils.escapeHtml4(abbreviateStart(sect.text, idx)));
                    int hitEnd = idx + term.length();
                    hit.append("<span class=\"hit\">")
                            .append(StringEscapeUtils.escapeHtml4(sect.text.substring(idx, hitEnd)))
                            .append("</span>");
                    hit.append(StringEscapeUtils.escapeHtml4(abbreviateEnd(sect.text, hitEnd)));
                    hit.append("</div>");

                    result.hits.add(hit.toString());

                    start = idx + 1;
                    idx = text.indexOf(term, start);
                }
                if (result.hits.size() > 10) {
                    int more = result.hits.size() - 10;
                    while (result.hits.size() > 10) {
                        result.hits.remove(result.hits.size() - 1);
                    }
                    result.hits.add("<div class=\"hit-info\">" + "And " + more + " more" + "</div>");
                }
                results.add(result);
            }
        }

        return results;
    }

    private String abbreviateStart(String text, int idx) {
        if (idx - LEN <= 0) {
            return text.substring(0, idx);
        } else {
            int startIdx = idx - LEN;
            while (text.charAt(startIdx) != ' ' && startIdx < idx) {
                startIdx++;
            }
            return "..." + text.substring(startIdx, idx);
        }
    }

    private String abbreviateEnd(String text, int idx) {
        if (idx + LEN >= text.length()) {
            return text.substring(idx);
        } else {
            int endIdx = idx + LEN;
            while (text.charAt(endIdx) != ' ' && endIdx > idx) {
                endIdx--;
            }
            return text.substring(idx, endIdx) + "...";
        }
    }
}