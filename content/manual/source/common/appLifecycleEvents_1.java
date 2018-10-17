package com.company.demo.core;

import com.haulmont.cuba.core.global.Events;
import com.haulmont.cuba.core.sys.events.*;
import org.slf4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class MyAppLifecycleBean {

    @Inject
    private Logger log;

    // event type is defined by annotation parameter
    @EventListener(AppContextInitializedEvent.class)
    // run after all platform listeners
    @Order(Events.LOWEST_PLATFORM_PRECEDENCE + 100)
    protected void appInitialized() {
        log.info("Initialized");
    }

    // event type is defined by method parameter
    @EventListener
    protected void appStarted(AppContextStartedEvent event) {
        log.info("Started");
    }

    @EventListener
    protected void appStopped(AppContextStoppedEvent event) {
        log.info("Stopped");
    }
}