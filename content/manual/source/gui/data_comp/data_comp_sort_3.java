package com.company.demo.web;

import com.haulmont.cuba.gui.model.*;
import javax.annotation.Nullable;

public class CustomSorterFactory extends SorterFactory {

    @Override
    public Sorter createCollectionContainerSorter(CollectionContainer container,
                                                  @Nullable BaseCollectionLoader loader) {
        return new CustomCollectionContainerSorter(container, loader);
    }
}