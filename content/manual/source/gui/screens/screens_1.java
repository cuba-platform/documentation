package com.company.sample.web.screen;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("sample_FancyMessageScreen")
@UiDescriptor("fancy-message-screen.xml")
public class FancyMessageScreen extends Screen {

    @Inject
    private Label<String> messageLabel;

    public void setFancyMessage(String message) {
        messageLabel.setValue(message);
    }

    @Subscribe("closeBtn")
    protected void onCloseBtnClick(Button.ClickEvent event) {
        close(WINDOW_CLOSE_ACTION);
    }
}