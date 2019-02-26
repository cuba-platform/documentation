package com.company.sales.web;

import com.company.sales.entity.Order;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.components.Timer;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Random;

@UiController("sales_OrdersHistory")
@UiDescriptor("orders-history.xml")
public class OrdersHistory extends Screen {
    @Inject
    private Metadata metadata;
    @Inject
    private TimeSource timeSource;

    @Inject
    private CollectionContainer<Order> ordersDc;

    private Random random = new Random(42);

    @Subscribe
    private void onInit(InitEvent event) {
        Order initialValue = metadata.create(Order.class);
        initialValue.setAmount(new BigDecimal(random.nextInt(1000) + 100));
        initialValue.setDate(timeSource.currentTimestamp());

        ordersDc.getMutableItems().add(initialValue);
    }
    
    

    public void updateChart(Timer source) {
        Order orderHistory = metadata.create(Order.class);
        orderHistory.setAmount(new BigDecimal(random.nextInt(1000) + 100));
        orderHistory.setDate(timeSource.currentTimestamp());;
        ordersDc.getMutableItems().add(orderHistory);
    }
}