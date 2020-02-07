package com.sample.sales.core;

import com.haulmont.cuba.core.Persistence;
import com.sample.sales.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {

    @Inject
    protected Persistence persistence;

    @Inject
    protected OrderWorker orderWorker;

    @Transactional
    @Override
    public BigDecimal calculateTotals(Order order) {
        Order entity = persistence.getEntityManager().merge(order);
        return orderWorker.calculateTotals(entity);
    }
}
