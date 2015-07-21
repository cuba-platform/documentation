package com.sample.sales.core;

import com.haulmont.cuba.core.*;
import com.haulmont.cuba.core.app.*;
import com.sample.sales.entity.Order;
import org.apache.commons.lang.exception.ExceptionUtils;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.UUID;

@ManagedBean("sales_OrdersMBean")
public class Orders implements OrdersMBean {

    @Inject
    protected OrderWorker orderWorker;

    @Inject
    protected Persistence persistence;

    @Authenticated
    @Override
    public String calculateTotals(final String orderId) {
        try {
            persistence.createTransaction().execute(new Transaction.Runnable() {
                @Override
                public void run(EntityManager em) {
                    Order entity = em.find(Order.class, UUID.fromString(orderId));
                    orderWorker.calculateTotals(entity);
                }
            });
            return "Done";
        } catch (Throwable e) {
            return ExceptionUtils.getStackTrace(e);
        }
    }
}