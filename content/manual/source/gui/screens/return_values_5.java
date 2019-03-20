package com.company.demo.web.screens;

import com.haulmont.cuba.gui.screen.StandardCloseAction;

public class MyCloseAction extends StandardCloseAction {

    private String result;

    public MyCloseAction(String result) {
        super("myCloseAction");
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}