package com.company.demo.web.mixins;

import com.haulmont.cuba.gui.model.DataLoader;
import java.util.Set;

public class DeclarativeLoaderParametersState {

    private Set<DataLoader> loadersToLoadBeforeShow;

    public DeclarativeLoaderParametersState(Set<DataLoader> loadersToLoadBeforeShow) {
        this.loadersToLoadBeforeShow = loadersToLoadBeforeShow;
    }

    public Set<DataLoader> getLoadersToLoadBeforeShow() {
        return loadersToLoadBeforeShow;
    }
}