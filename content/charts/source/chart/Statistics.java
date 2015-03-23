package com.sample.library.web.charts.statistics;

import com.haulmont.charts.gui.amcharts.model.Graph;
import com.haulmont.charts.gui.amcharts.model.GraphType;
import com.haulmont.charts.gui.amcharts.model.charts.SerialChart;
import com.haulmont.charts.gui.amcharts.model.data.ListDataProvider;
import com.haulmont.charts.gui.amcharts.model.data.MapDataItem;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.sample.library.entity.BooksByGenre;
import com.sample.library.service.StatisticsService;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Statistics extends AbstractWindow {

    @Inject
    private CollectionDatasource<BooksByGenre, UUID> pieDs;

    @Inject
    private Chart stackedChart;

    @Inject
    private StatisticsService statisticsService;

    public void init(Map<String, Object> param) {
        initPieChart();
        initStackedChart();
    }

    private void initPieChart() {
        pieDs.refresh();

        List<BooksByGenre> booksByGenreList = statisticsService.getCountOfBooksByGenre();
        for (BooksByGenre booksByGenre : booksByGenreList) {
            pieDs.includeItem(booksByGenre);
        }
    }

    private void initStackedChart() {
        List<String> allPublishers = statisticsService.getTopPublishers(5);
        Map<Integer, Map<String, Long>> structuredData = statisticsService.getCountOfBooksByPublisherAndYear();

        ListDataProvider dataProvider = new ListDataProvider();

        for (Map.Entry<Integer, Map<String, Long>> entry : structuredData.entrySet()) {
            MapDataItem mapDataItem = new MapDataItem().add("year", entry.getKey());

            for (String publisher : allPublishers) {
                if (entry.getValue().containsKey(publisher)) {
                    mapDataItem.add(publisher, entry.getValue().get(publisher));
                } else {
                    mapDataItem.add(publisher, 0);
                }
            }
            dataProvider.addItem(mapDataItem);
        }

        SerialChart stackedChartConfiguration = (SerialChart) stackedChart.getConfiguration();
        stackedChartConfiguration.setDataProvider(dataProvider);

        Graph[] graphs = new Graph[allPublishers.size()];
        int i = 0;
        for (String publisher : allPublishers) {
            Graph publisherGraph = new Graph();
            publisherGraph.setFillAlphas(0.6);
            publisherGraph.setLineAlpha(0.4);
            publisherGraph.setTitle(publisher);
            publisherGraph.setType(GraphType.LINE);
            publisherGraph.setValueField(publisher);
            publisherGraph.setBalloonText(publisher + " - [[year]] year: [[" + publisher + "]] books");

            graphs[i] = publisherGraph;
            i++;
        }
        stackedChartConfiguration.addGraphs(graphs);
    }
}
