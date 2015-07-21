package com.company.myproject.gui.components;

import com.haulmont.cuba.gui.components.Component;

public interface MyComponent extends Component {

    String NAME = "myComponent";

    int getSomeParameter();
    void setSomeParameter(int value);
}