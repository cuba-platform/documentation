package com.company.demo.web.screens;

import com.haulmont.cuba.gui.screen.*;
import com.company.demo.entity.Customer;

// common annotations
@UiController("demo_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LoadDataBeforeShow
// lookup-specific annotations
@LookupComponent("customersTable")
@PrimaryLookupScreen(Customer.class)
public class CustomerBrowse extends StandardLookup<Customer> {
}