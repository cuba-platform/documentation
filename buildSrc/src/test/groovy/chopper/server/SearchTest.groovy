package chopper.server

import spock.lang.Specification

class SearchTest extends Specification {

    List<Search.Sect> sections = [
            new Search.Sect("file1", "file1", "one two three", "one two three"),
            new Search.Sect("file2", "file2", "two three four", "two three four"),
            new Search.Sect("file3", "file3", "three four five", "three four five")
    ]

    private Search searcher

    void setup() {
        searcher = new Search(sections)
    }

    def "sorting of results"() {
        when:

        def results = searcher.search("three four five", false)

        then:

        results.size() == 3
        results[0].captionPath == "file3"
        results[1].captionPath == "file2"
        results[2].captionPath == "file1"
    }

    def "search term in quotes"() {
        when:

        def results = searcher.search("\"three four five\"", false)

        then:

        results.size() == 1
        results[0].captionPath == "file3"
    }

    def "less than 3 symbols in quotes return empty list"() {
        when:

        def results = searcher.search("\"on\"", false)

        then:

        results.size() == 0
    }
}
