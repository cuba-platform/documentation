package com.company.sales.core;

import com.haulmont.cuba.security.entity.User;
import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

    private User user;

    public DemoEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}