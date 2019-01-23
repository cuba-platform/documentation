package com.company.demo.web.navigation;

import com.company.demo.entity.Task;
import com.google.common.collect.ImmutableMap;
import com.haulmont.cuba.gui.Route;
import com.haulmont.cuba.gui.UrlRouting;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.sys.navigation.UrlIdSerializer;

import javax.inject.Inject;

@Route("task-info")
@UiController("demo_TaskInfoScreen")
@UiDescriptor("task-info.xml")
@LoadDataBeforeShow
public class TaskInfoScreen extends Screen {

    @Inject
    private LookupField<Task> taskField;

    @Inject
    private UrlRouting urlRouting;

    @Subscribe("selectBtn")
    protected void onSelectBtnClick(Button.ClickEvent event) {
        Task task = taskField.getValue(); // <1>
        if (task == null) {
            urlRouting.replaceState(this); // <2>
            return;
        }
        String serializedTaskId = UrlIdSerializer.serializeId(task.getId()); // <3>

        urlRouting.replaceState(this, ImmutableMap.of("task_id", serializedTaskId)); // <4>
    }
}