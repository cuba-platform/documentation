package com.sample.sales.core;

import com.sample.sales.entity.Order;

public interface OrderService {
    String NAME = "sales_OrderService";

    void calculateTotals(Order order);
}