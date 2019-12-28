package com.company.demo.core;

import com.company.demo.DemoTestContainer;
import com.company.demo.entity.Customer;
import com.haulmont.cuba.core.entity.contracts.Id;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    // Using the common singleton instance of the test container which is initialized once for all tests
    @RegisterExtension
    static DemoTestContainer cont = DemoTestContainer.Common.INSTANCE;

    static DataManager dataManager;

    @BeforeAll
    static void beforeAll() {
        // Get a bean from the container
        dataManager = AppBeans.get(DataManager.class);
    }

    @Test
    void testCreateLoadRemove() {
        Customer customer = cont.metadata().create(Customer.class);
        customer.setName("c1");

        Customer committedCustomer = dataManager.commit(customer);
        assertEquals(customer, committedCustomer);

        Customer loadedCustomer = dataManager.load(Id.of(customer)).one();
        assertEquals(customer, loadedCustomer);

        dataManager.remove(loadedCustomer);
    }
}