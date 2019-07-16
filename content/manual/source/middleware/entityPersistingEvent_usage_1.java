package com.company.demo.core;

import com.company.demo.entity.Customer;
import com.haulmont.cuba.core.app.events.EntityPersistingEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("demo_CustomerChangedListener")
public class CustomerChangedListener {

    @EventListener
    void beforePersist(EntityPersistingEvent<Customer> event) {
        Customer customer = event.getEntity();
        customer.setCode(obtainNewCustomerCode(customer));
    }

    // ...
}