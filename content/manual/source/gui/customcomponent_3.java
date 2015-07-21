package com.company.myproject.web;

import com.company.myproject.gui.components.MyComponent;
import com.company.myproject.web.components.WebMyComponent;
import com.haulmont.cuba.gui.ComponentPalette;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentLoader;
import java.util.HashMap;
import java.util.Map;

public class AppComponentPalette implements ComponentPalette {

    @Override
    public Map<String, Class<? extends Component>> getComponents() {
        Map<String, Class<? extends Component>> components = new HashMap<>();
        components.put(MyComponent.NAME, WebMyComponent.class);
        return components;
    }

    @Override
    public Map<String, Class<? extends ComponentLoader>> getLoaders() {
        return Collections.emptyMap();
    }
}