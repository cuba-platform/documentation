package com.company.addondemo.web.customer;

import com.company.addondemo.entity.Customer;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.components.VBoxLayout;
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

    private IntStepper stepper = new IntStepper();

    @Override
    public void init(Map<String, Object> params) {
        fieldGroup.addCustomField("score", (datasource, propertyId) -> {
            Component box = componentsFactory.createComponent(VBoxLayout.class);
            Layout layout = (Layout) WebComponentsHelper.unwrap(box);
            layout.addComponent(stepper);
            stepper.setSizeFull();

            stepper.addValueChangeListener(event ->
                    datasource.getItem().setValue(propertyId, event.getProperty().getValue()));

            return box;
        });
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