package com.company.demo.web.mixins;

import com.haulmont.cuba.gui.model.DataLoader;
import java.util.Set;

public class DeclarativeLoaderParametersExt {

    private Set<DataLoader> loadersToLoadBeforeShow;

    public void setLoadersToLoadBeforeShow(Set<DataLoader> loadersToLoadBeforeShow) {
        this.loadersToLoadBeforeShow = loadersToLoadBeforeShow;
    }

    public Set<DataLoader> getLoadersToLoadBeforeShow() {
        return loadersToLoadBeforeShow;
    }
}