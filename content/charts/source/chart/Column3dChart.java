package com.company.sampler.web;

import com.company.sampler.entity.CountryGrowth;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@UiController("sampler_Column3dChart")
@UiDescriptor("column3d-chart.xml")
public class Column3dChart extends Screen {

    @Inject
    private CollectionContainer<CountryGrowth> countryGrowthDc;

    @Subscribe
    private void onInit(InitEvent event) {
        List<CountryGrowth> items = new ArrayList<>();
        items.add(countryGrowth("USA", 3.5, 4.2));
        items.add(countryGrowth("UK", 1.7, 3.1));
        items.add(countryGrowth("Canada", 2.8, 2.9));
        items.add(countryGrowth("Japan", 2.6, 2.3));
        items.add(countryGrowth("France", 1.4, 2.1));
        items.add(countryGrowth("Brazil", 2.6, 4.9));
        items.add(countryGrowth("Russia", 6.4, 7.2));
        items.add(countryGrowth("India", 8.0, 7.1));
        items.add(countryGrowth("China", 9.9, 10.1));
        countryGrowthDc.setItems(items);
    }

    private CountryGrowth countryGrowth(String country, double year2014, double year2015) {
        CountryGrowth cg = new CountryGrowth();
        cg.setCountry(country);
        cg.setYear2014(year2014);
        cg.setYear2015(year2015);
        return cg;
    }
}