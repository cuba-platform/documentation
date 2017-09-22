package com.company.jscomponent.web.product;

import com.company.jscomponent.web.toolkit.ui.slider.SliderServerComponent;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.jscomponent.entity.Product;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.vaadin.ui.Layout;

import javax.inject.Inject;

public class ProductEdit extends AbstractEditor<Product> {

    @Inject
    private FieldGroup fieldGroup;

    @Inject
    private ComponentsFactory componentsFactory;

    @Inject
    private Datasource<Product> productDs;

    @Override
    protected void initNewItem(Product item) {
        super.initNewItem(item);
        item.setMinDiscount(15.0);
        item.setMaxDiscount(70.0);
    }

    @Override
    protected void postInit() {
        super.postInit();

        Component box = componentsFactory.createComponent(VBoxLayout.class);
        Layout vBox = (Layout) WebComponentsHelper.unwrap(box);
        SliderServerComponent slider = new SliderServerComponent();
        slider.setValue(new double[]{getItem().getMinDiscount(), getItem().getMaxDiscount()});
        slider.setMinValue(0);
        slider.setMaxValue(100);
        slider.setWidth("240px");
        slider.setListener(newValue -> {
            getItem().setMinDiscount(newValue[0]);
            getItem().setMaxDiscount(newValue[1]);
        });
        vBox.addComponent(slider);
        fieldGroup.getFieldNN("slider").setComponent(box);
    }
}