package com.company.demo.core;

import com.haulmont.cuba.core.sys.events.AppContextStartedEvent;
import com.haulmont.cuba.core.sys.events.AppContextStoppedEvent;
import org.slf4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class MyAppLifecycleBean {

    @Inject
    private Logger log;

    @EventListener
    private void appStarted(AppContextStartedEvent event) {
        log.info("Started");
    }

    @EventListener
    private void appStopped(AppContextStoppedEvent event) {
        log.info("Stopped");
    }
}