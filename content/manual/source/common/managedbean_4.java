// OrderWorkerBean.java – implementation
package com.sample.sales.core;

import com.sample.sales.entity.Order;
import javax.annotation.ManagedBean;

@ManagedBean(OrderWorker.NAME)
public class OrderWorkerBean implements OrderWorker {
    @Override
    public void calculateTotals(Order order) {
    }
}