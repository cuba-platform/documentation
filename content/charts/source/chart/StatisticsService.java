package com.sample.library.service;

import com.sample.library.entity.BooksByGenre;
import java.util.List;
import java.util.Map;

public interface StatisticsService {
    String NAME = "library_StatisticsService";

    public List<BooksByGenre> getCountOfBooksByGenre();

    public List<String> getTopPublishers(int count);

    public Map<Integer, Map<String, Long>> getCountOfBooksByPublisherAndYear();
}
