package com.company.sample.web;

import com.haulmont.cuba.gui.Route;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.auth.LoginPasswordCredentials;
import com.haulmont.cuba.web.App;

@UiController("myLogin")
@UiDescriptor("my-login-screen.xml")
@Route(path = "login", root = true)
public class MyLoginScreen extends Screen {

    @Subscribe("loginBtn")
    private void onLoginBtnClick(Button.ClickEvent event) {
        App.getInstance().getConnection().login(
                new LoginPasswordCredentials("admin", "admin"));
    }
}