package com.company.demo.web.mixins;

import com.haulmont.cuba.core.global.BeanLocator;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.theme.HaloTheme;

public interface HasBanner {

    @Subscribe
    default void initBanner(Screen.InitEvent event) {
        BeanLocator beanLocator = Extensions.getBeanLocator(event.getSource()); // <1>
        UiComponents uiComponents = beanLocator.get(UiComponents.class); // <2>

        Label<String> banner = uiComponents.create(Label.TYPE_STRING); // <3>
        banner.setStyleName(HaloTheme.LABEL_H2);
        banner.setValue("Hello, world!");

        event.getSource().getWindow().add(banner, 0); // <4>
    }
}
