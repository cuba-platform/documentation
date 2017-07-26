package com.company.bpmdemo.core;

import org.springframework.stereotype.Component;
import com.company.bpmdemo.entity.Contract;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;

import javax.inject.Inject;
import java.util.UUID;

@Component("demo_ApprovalHelper")
public class ApprovalHelper {

    @Inject
    private Persistence persistence;

    public void updateState(UUID entityId, String state) {
        try (Transaction tx = persistence.getTransaction()) {
            Contract contract = persistence.getEntityManager().find(Contract.class, entityId);
            if (contract != null) {
                contract.setState(state);
            }
            tx.commit();
        }
    }
}