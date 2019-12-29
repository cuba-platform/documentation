package com.company.demo.web.screens;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;

@UiController("demo_OtherScreen2")
@UiDescriptor("other-screen.xml")
public class OtherScreen2 extends Screen {

    @Subscribe("okBtn")
    public void onOkBtnClick(Button.ClickEvent event) {
        close(new MyCloseAction("Done")); // <1>
    }

    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        closeWithDefaultAction(); // <2>
    }
}