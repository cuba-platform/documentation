package chopper.server;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SearchResult {

    public final String fileName;
    public final String captionPath;
    public final String captionName;
    public final List<String> hits = new ArrayList<>();

    public SearchResult(String fileName, String captionPath, String captionName) {
        this.fileName = fileName;
        this.captionPath = captionPath;
        this.captionName = captionName;
    }
}
