package com.company.demo.core;

import com.company.demo.entity.Customer;
import com.haulmont.cuba.core.app.events.AttributeChanges;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.entity.contracts.Id;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import java.util.UUID;

@Component("demo_CustomerChangedListener")
public class CustomerChangedListener {

    @EventListener // <1>
    public void beforeCommit(EntityChangedEvent<Customer, UUID> event) {
        Id<Customer, UUID> entityId = event.getEntityId(); // <2>
        EntityChangedEvent.Type changeType = event.getType(); // <3>

        AttributeChanges changes = event.getChanges();
        if (changes.isChanged("name")) { // <4>
            String oldName = changes.getOldValue("name"); // <5>
            // ...
        }
    }

    @TransactionalEventListener // <6>
    public void afterCommit(EntityChangedEvent<Customer, UUID> event) {
        // <7>
    }
}
