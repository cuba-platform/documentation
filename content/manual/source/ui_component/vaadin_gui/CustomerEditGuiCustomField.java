package com.company.addonguidemo.gui.customer;

import com.company.addonguidemo.entity.Customer;
import com.company.addonguidemo.gui.components.Stepper;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.Map;

public class CustomerEdit extends AbstractEditor<Customer> {

    @Inject
    private ComponentsFactory componentsFactory;
    @Inject
    private FieldGroup fieldGroup;

    @Override
    public void init(Map<String, Object> params) {
        fieldGroup.addCustomField("score", (datasource, propertyId) -> {
            Stepper stepper = componentsFactory.createComponent(Stepper.class);
            stepper.setDatasource(datasource, propertyId);
            stepper.setWidth("100%");
            return stepper;
        });
    }
}