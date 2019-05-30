package com.company.sales.web.customer;

import com.company.sales.entity.Customer;
import com.company.sales.web.SalesWebTestContainer;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.OpenMode;
import com.haulmont.cuba.web.app.main.MainScreen;
import com.haulmont.cuba.web.testsupport.TestEntityFactory;
import com.haulmont.cuba.web.testsupport.TestEntityState;
import com.haulmont.cuba.web.testsupport.TestUiEnvironment;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class CustomerEditInteractionTest {

    @Rule
    public TestUiEnvironment environment =
            new TestUiEnvironment(SalesWebTestContainer.Common.INSTANCE).withUserLogin("admin"); // <1>

    private Customer customer;

    @Before
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