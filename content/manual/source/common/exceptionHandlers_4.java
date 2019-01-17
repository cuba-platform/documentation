package com.company.demo.web.exceptions;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.exception.AbstractUiExceptionHandler;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    protected boolean canHandle(String className, String message, @Nullable Throwable throwable) {
        return StringUtils.containsIgnoreCase(message, "Insufficient funds in your account");
    }
}