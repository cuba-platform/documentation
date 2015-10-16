package com.sample.sales.core;

import com.haulmont.cuba.core.*;
import com.haulmont.cuba.core.app.*;
import com.sample.sales.entity.Order;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.util.UUID;

@Component("sales_OrdersMBean")
public class Orders implements OrdersMBean {

    @Inject
    protected OrderWorker orderWorker;

    @Inject
    protected Persistence persistence;

    @Authenticated
    @Override
    public String calculateTotals(String orderId) {
        try {
            try (Transaction tx = persistence.createTransaction()) {
                Order entity = persistence.getEntityManager().find(Order.class, UUID.fromString(orderId));
                orderWorker.calculateTotals(entity);
                tx.commit();
            };
            return "Done";
        } catch (Throwable e) {
            return ExceptionUtils.getStackTrace(e);
        }
    }
}