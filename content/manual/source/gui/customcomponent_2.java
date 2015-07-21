package com.company.myproject.web.components;

import com.company.myproject.gui.components.MyComponent;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;

public class WebMyComponent
        extends WebAbstractComponent<org.vaadin.someaddon.SomeComponent>
        implements MyComponent {

    public WebMyComponent() {
        component = new org.vaadin.someaddon.SomeComponent();
    }

    @Override
    public int getSomeParameter() {
        return component.getSomeParameter();
    }

    @Override
    public void setSomeParameter(boolean value) {
        component.setSomeParameter(value);
    }
}