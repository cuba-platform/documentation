package com.sample.sales.core;

import org.springframework.jmx.export.annotation.*;
import com.haulmont.cuba.core.sys.jmx.JmxBean;

@JmxBean(module = "sales", alias = "OrdersMBean")
@ManagedResource(description = "Performs operations on Orders")
public interface OrdersMBean {
    @ManagedOperation(description = "Recalculates an order amount")
    @ManagedOperationParameters({@ManagedOperationParameter(name = "orderId", description = "")})
    String calculateTotals(String orderId);
}