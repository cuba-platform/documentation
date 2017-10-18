package com.company.sample.web.order;

import com.company.sample.entity.Order;
import com.haulmont.cuba.gui.AttributeAccessSupport;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.Map;

public class OrderEdit extends AbstractEditor<Order> {

    @Inject
    private Datasource<Order> orderDs;

    @Inject
    private AttributeAccessSupport attributeAccessSupport;

    @Override
    public void init(Map<String, Object> params) {
        orderDs.addItemPropertyChangeListener(e -> {
            if ("customer".equals(e.getProperty())) {
                attributeAccessSupport.applyAttributeAccess(this, true, getItem());
            }
        });
    }
}