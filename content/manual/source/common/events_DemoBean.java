package com.company.sales.core;

import com.haulmont.cuba.core.global.Events;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.security.global.UserSession;
import org.springframework.stereotype.Component;
import javax.inject.Inject;

@Component
public class DemoBean {

    @Inject
    private Events events;
    @Inject
    private UserSessionSource userSessionSource;

    public void demo() {
        UserSession userSession = userSessionSource.getUserSession();
        events.publish(new DemoEvent(this, userSession.getUser()));
    }
}