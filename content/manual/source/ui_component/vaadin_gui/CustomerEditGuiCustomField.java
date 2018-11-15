package com.company.addonguidemo.web.customer;

import com.company.addonguidemo.entity.Customer;
import com.company.addonguidemo.gui.components.Stepper;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.Map;

public class CustomerEdit extends AbstractEditor<Customer> {

    @Inject
    private UiComponents uiComponents;
    @Inject
    private FieldGroup fieldGroup;
    @Inject
    private Datasource<Customer> customerDs;

    @Override
    public void init(Map<String, Object> params) {
        Stepper stepper = uiComponents.create(Stepper.class);
        stepper.setDatasource(customerDs, "score");
        stepper.setWidth("100%");
        fieldGroup.getFieldNN("score").setComponent(stepper);
    }
}