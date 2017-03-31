package com.company.addondemo.web.customer;

import com.haulmont.cuba.gui.components.*;
import com.company.addondemo.entity.Customer;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.vaadin.ui.Layout;
import org.vaadin.risto.stepper.IntStepper;

import javax.inject.Inject;
import java.util.Map;

public class CustomerEdit extends AbstractEditor<Customer> {

    @Inject
    private FieldGroup fieldGroup;

    @Inject
    private Datasource<Customer> customerDs;

    @Inject
    private BoxLayout scoreBox;

    private IntStepper stepper = new IntStepper();

    @Override
    public void init(Map<String, Object> params) {

        Layout box = (Layout) WebComponentsHelper.unwrap(scoreBox);
        box.addComponent(stepper);

        fieldGroup.addField(fieldGroup.createField("score"));

        stepper.setSizeFull();
        stepper.addValueChangeListener(event ->
                customerDs.getItem().setValue("score", event.getProperty().getValue())
        );
    }

    @Override
    protected void initNewItem(Customer item) {
        item.setScore(0);
    }

    @Override
    protected void postInit() {
        stepper.setValue(getItem().getScore());
    }
}