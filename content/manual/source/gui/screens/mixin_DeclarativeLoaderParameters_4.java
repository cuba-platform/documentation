package com.company.demo.web.country;

import com.company.demo.entity.Country;
import com.company.demo.web.mixins.DeclarativeLoaderParameters;
import com.haulmont.cuba.gui.screen.*;

@UiController("demo_Country.browse")
@UiDescriptor("country-browse.xml")
@LookupComponent("countriesTable")
public class CountryBrowse extends StandardLookup<Country>
                           implements DeclarativeLoaderParameters {
}