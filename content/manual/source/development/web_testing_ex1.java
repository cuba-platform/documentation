package com.company.demo.customer;

import com.company.demo.DemoWebTestContainer;
import com.company.demo.entity.Customer;
import com.company.demo.web.screens.customer.CustomerEdit;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.OpenMode;
import com.haulmont.cuba.web.app.main.MainScreen;
import com.haulmont.cuba.web.testsupport.TestEntityFactory;
import com.haulmont.cuba.web.testsupport.TestEntityState;
import com.haulmont.cuba.web.testsupport.TestUiEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CustomerEditInteractionTest {

    @RegisterExtension
    TestUiEnvironment environment =
            new TestUiEnvironment(DemoWebTestContainer.Common.INSTANCE).withUserLogin("admin"); // <1>

    private Customer customer;

    @BeforeEach
    public void setUp() throws Exception {
        TestEntityFactory<Customer> customersFactory =
                environment.getContainer().getEntityFactory(Customer.class, TestEntityState.NEW);

        customer = customersFactory.create(Collections.emptyMap()); // <2>
    }

    @Test
    public void testGenerateName() {
        Screens screens = environment.getScreens(); // <3>

        screens.create(MainScreen.class, OpenMode.ROOT).show(); // <4>

        CustomerEdit customerEdit = screens.create(CustomerEdit.class); // <5>
        customerEdit.setEntityToEdit(customer);
        customerEdit.show();

        assertNull(customerEdit.getEditedEntity().getName());

        Button generateBtn = (Button) customerEdit.getWindow().getComponent("generateBtn"); // <6>
        customerEdit.onGenerateBtnClick(new Button.ClickEvent(generateBtn)); // <7>

        assertEquals("Generated name", customerEdit.getEditedEntity().getName());
    }
}