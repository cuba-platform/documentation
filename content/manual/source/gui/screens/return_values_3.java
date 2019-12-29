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
    public void onOkBtnClick(Button.ClickEvent event) {
        result = "Done";
        close(StandardOutcome.COMMIT); // <1>
    }

    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        close(StandardOutcome.CLOSE); // <2>
    }
}