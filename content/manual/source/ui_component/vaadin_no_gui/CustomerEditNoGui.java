package com.company.demo.web.customer;

import com.company.demo.entity.Customer;
import com.haulmont.cuba.gui.components.HBoxLayout;
import com.haulmont.cuba.gui.screen.*;
import com.vaadin.ui.Layout;
import org.vaadin.risto.stepper.IntStepper;

import javax.inject.Inject;

@UiController("demo_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
    @Inject
    private HBoxLayout scoreBox;

    private IntStepper stepper = new IntStepper();

    @Subscribe
    protected void onInit(InitEvent event) {
        scoreBox.unwrap(Layout.class)
                .addComponent(stepper);

        stepper.setSizeFull();
        stepper.addValueChangeListener(valueChangeEvent ->
                getEditedEntity().setScore(valueChangeEvent.getValue()));
    }

    @Subscribe
    protected void onInitEntity(InitEntityEvent<Customer> event) {
        event.getEntity().setScore(0);
    }

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        stepper.setValue(getEditedEntity().getScore());
    }
}
