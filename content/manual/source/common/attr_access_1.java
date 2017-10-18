package com.company.sample.core;

import com.company.sample.entity.Order;
import com.haulmont.cuba.core.app.events.SetupAttributeAccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("sample_AttributeAccessRules")
public class AttributeAccessRules {

    @EventListener
    public void orderAccess(SetupAttributeAccessEvent<Order> event) {
        Order order = event.getEntity();
        if (order.getCustomer() != null) {
            if ("PLATINUM".equals(order.getCustomer().getGrade().getCode())) {
                event.addHidden("amount");
            } else if ("GOLD".equals(order.getCustomer().getGrade().getCode())) {
                event.addReadOnly("amount");
            }
        }
    }
}