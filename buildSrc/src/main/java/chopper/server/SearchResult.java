package chopper.server;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SearchResult implements Comparable<SearchResult> {

    public final String fileName;
    public final String captionPath;
    public final String captionName;
    public final List<String> hits = new ArrayList<>();
    private int captionWeight;
    private int bodyWeight;

    public SearchResult(String fileName, String captionPath, String captionName) {
        this.fileName = fileName;
        this.captionPath = captionPath;
        this.captionName = captionName;
    }

    public void setCaptionWeight(int captionWeight) {
        this.captionWeight = captionWeight;
    }

    public void setBodyWeight(int bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    @Override
    public int compareTo(SearchResult o) {
        int res = o.captionWeight - captionWeight;
        return res != 0 ? res : o.bodyWeight - bodyWeight;
    }
}
