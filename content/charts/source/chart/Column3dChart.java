package com.company.sampler.web.screens;

import com.company.sampler.entity.CountryGrowth;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class Column3dChart extends AbstractWindow {
    @Inject
    private CollectionDatasource<CountryGrowth, UUID> countryGrowthDs;

    @Override
    public void init(Map<String, Object> params) {
        countryGrowthDs.refresh();

        countryGrowthDs.includeItem(countryGrowth("USA", 3.5, 4.2));
        countryGrowthDs.includeItem(countryGrowth("UK", 1.7, 3.1));
        countryGrowthDs.includeItem(countryGrowth("Canada", 2.8, 2.9));
        countryGrowthDs.includeItem(countryGrowth("Japan", 2.6, 2.3));
        countryGrowthDs.includeItem(countryGrowth("France", 1.4, 2.1));
        countryGrowthDs.includeItem(countryGrowth("Brazil", 2.6, 4.9));
        countryGrowthDs.includeItem(countryGrowth("Russia", 6.4, 7.2));
        countryGrowthDs.includeItem(countryGrowth("India", 8.0, 7.1));
        countryGrowthDs.includeItem(countryGrowth("China", 9.9, 10.1));
    }

    private CountryGrowth countryGrowth(String country, double year2014, double year2015) {
        CountryGrowth cg = new CountryGrowth();
        cg.setCountry(country);
        cg.setYear2014(year2014);
        cg.setYear2015(year2015);
        return cg;
    }
}