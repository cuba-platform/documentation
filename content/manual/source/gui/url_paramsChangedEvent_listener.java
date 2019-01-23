package com.company.demo.web.navigation;

import com.company.demo.entity.Task;
import com.google.common.collect.ImmutableMap;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Route;
import com.haulmont.cuba.gui.UrlRouting;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.navigation.UrlParamsChangedEvent;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.sys.navigation.UrlIdSerializer;

import javax.inject.Inject;
import java.util.UUID;

@Route("task-info")
@UiController("demo_TaskInfoScreen")
@UiDescriptor("task-info.xml")
@LoadDataBeforeShow
public class TaskInfoScreen extends Screen {

    @Inject
    private LookupField<Task> taskField;

    @Inject
    private UrlRouting urlRouting;

    @Inject
    private DataManager dataManager;

    @Subscribe
    protected void onUrlParamsChanged(UrlParamsChangedEvent event) {
        String serializedTaskId = event.getParams().get("task_id"); // <1>

        UUID taskId = (UUID) UrlIdSerializer.deserializeId(UUID.class, serializedTaskId); // <2>

        taskField.setValue(dataManager.load(Task.class).id(taskId).one()); // <3>
    }

    @Subscribe("selectBtn")
    protected void onSelectBtnClick(Button.ClickEvent event) {
        Task task = taskField.getValue();
        if (task == null) {
            urlRouting.replaceState(this);
            return;
        }
        String serializedTaskId = UrlIdSerializer.serializeId(task.getId());

        urlRouting.replaceState(this, ImmutableMap.of("task_id", serializedTaskId));
    }
}