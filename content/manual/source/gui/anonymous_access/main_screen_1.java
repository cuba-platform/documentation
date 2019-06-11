package com.company.demo.web.main;

import com.company.demo.web.info.InfoScreen;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.main.MainScreen;

import javax.inject.Inject;

@UiController("main")
@UiDescriptor("ext-main-screen.xml")
public class ExtMainScreen extends MainScreen {

    @Inject
    private Screens screens;

    @Subscribe("openInfoBtn")
    private void onOpenInfoBtnClick(Button.ClickEvent event) {
        screens.create(InfoScreen.class, OpenMode.ROOT).show(); // <1>
    }
}