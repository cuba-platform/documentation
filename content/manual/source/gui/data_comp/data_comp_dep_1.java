package com.company.sales.web.order;

import com.company.sales.entity.Order;
import com.company.sales.entity.OrderLine;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import javax.inject.Inject;

@UiController("order-list")
@UiDescriptor("order-list.xml")
@LookupComponent("ordersTable")
public class OrderList extends StandardLookup<Order> { // <1>

    @Inject
    private CollectionLoader<Order> ordersDl;
    @Inject
    private CollectionLoader<OrderLine> orderLinesDl;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        ordersDl.load(); // <2>
    }

    @Subscribe(id = "ordersDc", target = Target.DATA_CONTAINER)
    protected void onOrdersDcItemChange(InstanceContainer.ItemChangeEvent<Order> event) {
        orderLinesDl.setParameter("order", event.getItem()); // <3>
        orderLinesDl.load();
    }
}