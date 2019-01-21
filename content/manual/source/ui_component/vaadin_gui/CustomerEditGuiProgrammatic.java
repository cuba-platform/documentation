package com.company.demo.web.customer;

import com.company.demo.entity.Customer;
import com.company.demo.web.gui.components.Stepper;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Form;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("demo_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
    @Inject
    private Form form;
    @Inject
    private InstanceContainer<Customer> customerDc;
    @Inject
    private UiComponents uiComponents;

    @Subscribe
    protected void onInit(InitEvent event) {
        Stepper stepper = uiComponents.create(Stepper.NAME);
        stepper.setValueSource(new ContainerValueSource<>(customerDc, "score"));
        stepper.setCaption("Score");
        stepper.setWidthFull();
        stepper.setMinValue(0);
        stepper.setMaxValue(20);

        form.add(stepper);
    }

    @Subscribe
    protected void onInitEntity(InitEntityEvent<Customer> event) {
        event.getEntity().setScore(0);
    }
}