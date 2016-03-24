package com.company.addondemo.web.customer;

import com.company.addondemo.entity.Customer;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.BoxLayout;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.vaadin.ui.Layout;
import org.vaadin.risto.stepper.IntStepper;

import javax.inject.Inject;
import java.util.Map;

public class CustomerEdit extends AbstractEditor<Customer> {

    @Inject
    private BoxLayout scoreBox;

    private IntStepper stepper = new IntStepper();

    @Override
    public void init(Map<String, Object> params) {
        com.vaadin.ui.Layout box = (Layout) WebComponentsHelper.unwrap(scoreBox);
        box.addComponent(stepper);

        stepper.addValueChangeListener(event -> getItem().setValue("score", event.getProperty().getValue()));
    }

    @Override
    protected void postInit() {
        stepper.setValue(getItem().getScore());
    }
}