package com.company.demo.web.info;

import com.haulmont.cuba.gui.Route;
import com.haulmont.cuba.gui.screen.*;

@UiController("demo_InfoScreen")
@UiDescriptor("info-screen.xml")
@Route(path = "info") // <1>
public class InfoScreen extends Screen {
}