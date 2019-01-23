package com.company.demo.web;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.exception.AbstractUiExceptionHandler;
import org.springframework.stereotype.Component;
import javax.annotation.Nullable;

@Component("demo_ZeroBalanceExceptionHandler")
public class ZeroBalanceExceptionHandler extends AbstractUiExceptionHandler {

    public ZeroBalanceExceptionHandler() {
        super(ZeroBalanceException.class.getName());
    }

    @Override
    protected void doHandle(String className, String message, @Nullable Throwable throwable, UiContext context) {
        context.getNotifications().create(Notifications.NotificationType.ERROR)
                .withCaption("Error")
                .withDescription(message)
                .show();
    }
}