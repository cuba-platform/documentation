package com.company.myproject.web;

import com.haulmont.cuba.web.DefaultApp;
import com.haulmont.cuba.web.gui.WebUIPaletteManager;

public class App extends DefaultApp {

    static {
        WebUIPaletteManager.registerPalettes(new AppComponentPalette());
    }
}