package com.company.ratingsample.web.screens.rating;

import com.company.ratingsample.web.toolkit.ui.RatingFieldServerComponent;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.vaadin.ui.Layout;

import javax.inject.Inject;

@UiController("ratingsample_RatingScreen")
@UiDescriptor("rating-screen.xml")
public class RatingScreen extends Screen {
    @Inject
    private VBoxLayout container;

    @Subscribe
    protected void onInit(InitEvent event) {
        RatingFieldServerComponent field = new RatingFieldServerComponent();
        field.setCaption("Rate this!");
        container.unwrap(Layout.class).addComponent(field);
    }
}