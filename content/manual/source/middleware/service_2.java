package com.sample.sales.core;

import com.sample.sales.entity.Order;
import org.springframework.stereotype.Service;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {
    @Override
    public void calculateTotals(Order order) {
    }
}