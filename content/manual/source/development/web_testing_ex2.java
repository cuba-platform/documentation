package com.company.demo.customer;

import com.company.demo.DemoWebTestContainer;
import com.company.demo.entity.Customer;
import com.company.demo.web.screens.customer.CustomerEdit;
import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.OpenMode;
import com.haulmont.cuba.gui.screen.UiControllerUtils;
import com.haulmont.cuba.web.app.main.MainScreen;
import com.haulmont.cuba.web.testsupport.TestEntityFactory;
import com.haulmont.cuba.web.testsupport.TestEntityState;
import com.haulmont.cuba.web.testsupport.TestUiEnvironment;
import com.haulmont.cuba.web.testsupport.proxy.TestServiceProxy;
import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerEditLoadDataTest {

    @RegisterExtension
    TestUiEnvironment environment =
            new TestUiEnvironment(DemoWebTestContainer.Common.INSTANCE).withUserLogin("admin"); // <1>

    @Mocked
    private DataService dataService; // <1>

    private Customer customer;

    @BeforeEach
    public void setUp() throws Exception {
        new Expectations() {{ // <2>
            dataService.load((LoadContext<? extends Entity>) any);
            result = new Delegate() {
                Entity load(LoadContext lc) {
                    if ("demo_Customer".equals(lc.getEntityMetaClass())) {
                        return customer;
                    } else
                        return null;
                }
            };
        }};

        TestServiceProxy.mock(DataService.class, dataService); // <3>

        TestEntityFactory<Customer> customersFactory =
                environment.getContainer().getEntityFactory(Customer.class, TestEntityState.DETACHED);

        customer = customersFactory.create(
                "name", "Homer", "email", "homer@simpson.com"); // <4>
    }

    @AfterEach
    public void tearDown() throws Exception {
        TestServiceProxy.clear(); // <5>
    }

    @Test
    public void testLoadData() {
        Screens screens = environment.getScreens();

        screens.create(MainScreen.class, OpenMode.ROOT).show();

        CustomerEdit customerEdit = screens.create(CustomerEdit.class);
        customerEdit.setEntityToEdit(customer);
        customerEdit.show();

        InstanceContainer customerDc = UiControllerUtils.getScreenData(customerEdit).getContainer("customerDc"); // <6>
        assertEquals(customer, customerDc.getItem());
    }
}