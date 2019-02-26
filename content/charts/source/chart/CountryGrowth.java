package com.company.sampler.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.BaseUuidEntity;

@MetaClass(name = "sampler_CountryGrowth")
public class CountryGrowth extends BaseUuidEntity {
    @MetaProperty
    protected String country;

    @MetaProperty
    protected Double year2014;

    @MetaProperty
    protected Double year2015;

    public Double getYear2015() {
        return year2015;
    }

    public void setYear2015(Double year2015) {
        this.year2015 = year2015;
    }

    public Double getYear2014() {
        return year2014;
    }

    public void setYear2014(Double year2014) {
        this.year2014 = year2014;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}