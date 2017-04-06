package com.company.addonguidemo.web.customer;

import com.company.addonguidemo.gui.components.Stepper;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.addonguidemo.entity.Customer;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.Map;

public class CustomerEdit extends AbstractEditor<Customer> {

    @Inject
    private ComponentsFactory componentsFactory;
    @Inject
    private FieldGroup fieldGroup;
    @Inject
    private Datasource<Customer> customerDs;

    @Override
    public void init(Map<String, Object> params) {
        Stepper stepper = componentsFactory.createComponent(Stepper.class);
        stepper.setDatasource(customerDs, "score");
        stepper.setWidth("100%");
        fieldGroup.getFieldNN("score").setComponent(stepper);
    }
}