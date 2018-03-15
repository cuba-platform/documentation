package com.company.sample.core;

import com.company.sample.entity.Order;
import com.haulmont.cuba.core.app.SetupAttributeAccessHandler;
import com.haulmont.cuba.core.app.events.SetupAttributeAccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("sample_OrderAttributeAccessHandler")
public class OrderAttributeAccessHandler implements SetupAttributeAccessHandler<Order> {

    @Override
    public boolean supports(Class clazz) {
        return Order.class.isAssignableFrom(clazz);
    }

    @Override
    public void setupAccess(SetupAttributeAccessEvent<Order> event) {
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