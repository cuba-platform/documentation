package com.company.sales;

import com.company.sales.entity.Customer;
import com.haulmont.cuba.core.global.*;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomerTest {

    // Using the common singleton instance of the test container which is initialized once for all tests
    @ClassRule
    public static SalesTestContainer cont = SalesTestContainer.Common.INSTANCE;

    private Metadata metadata;

    @Before
    public void setUp() throws Exception {
        metadata = cont.metadata();
    }

    @Test
    public void testCreateCustomer() throws Exception {
        // Get a managed bean (or service) from container
        DataManager dataManager = AppBeans.get(DataManager.class);

        // Create new Customer
        Customer customer = metadata.create(Customer.class);
        customer.setName("Test customer");

        // Save the customer to the database
        dataManager.commit(customer);

        // Load the customer by ID
        Customer loaded = dataManager.load(
                LoadContext.create(Customer.class).setId(customer.getId()).setView(View.LOCAL));

        assertNotNull(loaded);
        assertEquals(customer.getName(), loaded.getName());

        // Remove the customer
        dataManager.remove(loaded);
    }
}