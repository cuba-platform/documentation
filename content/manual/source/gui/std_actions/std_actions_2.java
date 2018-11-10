package com.company.sample.web.actions;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.MetadataTools;
import com.haulmont.cuba.gui.ComponentsHelper;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.ActionType;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.actions.ItemTrackingAction;

import javax.inject.Inject;

@ActionType("showSelected")
public class ShowSelectedAction extends ItemTrackingAction {

    @Inject
    private MetadataTools metadataTools;

    public ShowSelectedAction(String id) {
        super(id);
        setCaption("Show Selected");
    }

    @Override
    public void actionPerform(Component component) {
        Entity selected = getTarget().getSingleSelected();
        if (selected != null) {
            Notifications notifications = ComponentsHelper.getScreenContext(target).getNotifications();
            notifications.create()
                    .setType(Notifications.NotificationType.TRAY)
                    .setCaption(metadataTools.getInstanceName(selected))
                    .show();
        }
    }
}