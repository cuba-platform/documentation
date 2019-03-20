package com.company.demo.web.screens;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;

@UiController("demo_OtherScreen")
@UiDescriptor("other-screen.xml")
public class OtherScreen extends Screen {

    private String result;

    public String getResult() {
        return result;
    }

    @Subscribe("okBtn")
    private void onOkBtnClick(Button.ClickEvent event) {
        result = "Done";
        close(WINDOW_COMMIT_AND_CLOSE_ACTION); // <1>
    }

    @Subscribe("cancelBtn")
    private void onCancelBtnClick(Button.ClickEvent event) {
        closeWithDefaultAction(); // <2>
    }
}