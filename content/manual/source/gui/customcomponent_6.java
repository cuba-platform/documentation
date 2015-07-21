package com.company.myproject.gui.loaders;

import com.company.myproject.gui.components.MyComponent;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.*;
import org.dom4j.Element;

public class MyComponentLoader extends ComponentLoader {

    public MyComponentLoader(Context context, LayoutLoaderConfig config, ComponentsFactory factory) {
        super(context, config, factory);
    }

    @Override
    public Component loadComponent(ComponentsFactory factory, Element element, Component parent) {
        MyComponent component = (MyComponent) super.loadComponent(factory, element, parent);

        String someParameter = element.attributeValue("someParameter");
        if (someParameter != null) {
            component.setSomeParameter(Integer.valueOf(someParameter));
        }
        return component;
    }
}