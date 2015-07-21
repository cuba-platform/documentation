package com.sample.sales.core;

import com.sample.sales.entity.Order;
import javax.annotation.ManagedBean;

@ManagedBean(OrderWorker.NAME)
public class OrderWorker {
    public static final String NAME = "sales_OrderWorker";

    public void calculateTotals(Order order) {
    }
}