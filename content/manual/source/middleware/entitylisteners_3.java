package com.company.sales.service;

import com.company.sales.entity.Customer;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component("sales_CustomerEntityListener")
public class CustomerEntityListener implements BeforeInsertEntityListener<Customer>, BeforeUpdateEntityListener<Customer> {

    @Override
    public void onBeforeInsert(Customer entity, EntityManager entityManager) {
        printCustomer(entity);
    }

    @Override
    public void onBeforeUpdate(Customer entity, EntityManager entityManager) {
        printCustomer(entity);
    }

    private void printCustomer(Customer customer) {
        System.out.println("In transaction: " + customer);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                System.out.println("After transaction commit: " + customer);
            }
        });
    }
}