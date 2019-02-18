package com.company.demo.web.customer;

import com.company.demo.web.mixins.HasBanner;
import com.haulmont.cuba.gui.screen.*;
import com.company.demo.entity.Customer;

@UiController("demo_Customer.edit")
@UiDescriptor("customer-edit.xml")
// ...
public class CustomerEdit extends StandardEditor<Customer> implements HasBanner {
    // ...
}