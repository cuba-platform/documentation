package com.company.ratingsample.web.screens;

import com.company.ratingsample.web.toolkit.ui.RatingFieldServerComponent;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.BoxLayout;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.vaadin.ui.Layout;

import javax.inject.Inject;
import java.util.Map;

public class RatingScreen extends AbstractWindow {
    @Inject
    private BoxLayout container;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        com.vaadin.ui.Layout containerLayout = (Layout) WebComponentsHelper.unwrap(container);
        RatingFieldServerComponent field = new RatingFieldServerComponent();
        field.setCaption("Rate this!");
        containerLayout.addComponent(field);
    }
}