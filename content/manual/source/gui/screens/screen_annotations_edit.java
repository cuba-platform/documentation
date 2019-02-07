package com.company.demo.web.data.sort;

import com.haulmont.cuba.gui.screen.*;
import com.company.demo.entity.Customer;

// common annotations
@UiController("demo_Customer.edit")
@UiDescriptor("customer-edit.xml")
@LoadDataBeforeShow
// editor-specific annotations
@EditedEntityContainer("customerDc")
@PrimaryEditorScreen(Customer.class)
public class CustomerEdit extends StandardEditor<Customer> {
}