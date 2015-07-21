package com.sample.sales.core;

import org.springframework.jmx.export.annotation.*;

@ManagedResource(description = "Performs operations on Orders")
public interface OrdersMBean {

    @ManagedOperation(description = "Recalculates an order amount")
    @ManagedOperationParameters({@ManagedOperationParameter(name = "orderId", description = "")})
    String calculateTotals(String orderId);
}