package com.company.sample.core;

import com.haulmont.cuba.core.global.Events;
import com.haulmont.cuba.core.sys.events.AppContextInitializedEvent;
import com.haulmont.cuba.core.sys.listener.EntityListenerManager;
import com.haulmont.cuba.security.entity.User;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.inject.Inject;

@Component("sample_AppLifecycle")
public class AppLifecycle {

    @Inject
    private EntityListenerManager entityListenerManager;

    @EventListener(AppContextInitializedEvent.class) // notify after AppContext is initialized
    @Order(Events.LOWEST_PLATFORM_PRECEDENCE + 100)  // run after all framework listeners
    public void initEntityListeners() {
        entityListenerManager.addListener(User.class, "sample_UserEntityListener");
    }
}