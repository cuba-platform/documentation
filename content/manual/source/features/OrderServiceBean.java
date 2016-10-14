package com.company.sales.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.math.BigDecimal;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {

    @Inject
    private Persistence persistence;

    @Override
    public BigDecimal calculatePrice(String orderNumber) {
        BigDecimal orderPrice = null;
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            orderPrice = (BigDecimal) em.createQuery("select sum(oi.price) from sales$OrderItem oi where oi.order.number = :orderNumber")
                    .setParameter("orderNumber", orderNumber)
                    .getSingleResult();
            tx.commit();
        }

        return orderPrice;
    }
}