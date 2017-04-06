package com.company.addondemo.web.customer;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.addondemo.entity.Customer;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.vaadin.ui.Layout;
import org.vaadin.risto.stepper.IntStepper;

import javax.inject.Inject;
import java.util.Map;

public class CustomerEdit extends AbstractEditor<Customer> {

    @Inject
    private ComponentsFactory componentsFactory;

    @Inject
    private FieldGroup fieldGroup;

    @Inject
    private Datasource<Customer> customerDs;

    private IntStepper stepper = new IntStepper();

    @Override
    public void init(Map<String, Object> params) {
        fieldGroup.createField("score");
        Component box = componentsFactory.createComponent(VBoxLayout.class);
        fieldGroup.getFieldNN("score").setComponent(box);
        Layout layout = (Layout) WebComponentsHelper.unwrap(box);
        layout.addComponent(stepper);
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