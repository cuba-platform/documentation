package com.company.demo.web.screens;

import com.haulmont.cuba.gui.screen.*;

@UiController("demo_FooScreen")
@UiDescriptor("foo-screen.xml")
@LoadDataBeforeShow
@MultipleOpen
@DialogMode(forceDialog = true)
public class FooScreen extends Screen {
}