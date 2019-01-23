package com.company.demo.web.navigation;

import com.haulmont.cuba.gui.Route;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

@Route("task-info")
@UiController("demo_TaskInfoScreen")
@UiDescriptor("task-info.xml")
public class TaskInfoScreen extends Screen {
}