// OrderWorker.java – interface
package com.sample.sales.core;

import com.sample.sales.entity.Order;

public interface OrderWorker {
    String NAME = "sales_OrderWorker";

    void calculateTotals(Order order);
}