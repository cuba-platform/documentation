package com.company.jscomponent.web.product;

import com.company.jscomponent.entity.Product;
import com.company.jscomponent.web.toolkit.ui.slider.SliderServerComponent;
import com.haulmont.cuba.gui.components.HBoxLayout;
import com.haulmont.cuba.gui.screen.*;
import com.vaadin.ui.Layout;

import javax.inject.Inject;

@UiController("jscomponent_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {

    @Inject
    private HBoxLayout sliderBox;

    @Subscribe
    protected void onInitEntity(InitEntityEvent<Product> event) {
        event.getEntity().setMinDiscount(15.0);
        event.getEntity().setMaxDiscount(70.0);
    }

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        SliderServerComponent slider = new SliderServerComponent();
        slider.setValue(new double[]{
                getEditedEntity().getMinDiscount(),
                getEditedEntity().getMaxDiscount()
        });
        slider.setMinValue(0);
        slider.setMaxValue(100);
        slider.setWidth("250px");
        slider.setListener(newValue -> {
            getEditedEntity().setMinDiscount(newValue[0]);
            getEditedEntity().setMaxDiscount(newValue[1]);
        });

        sliderBox.unwrap(Layout.class).addComponent(slider);
    }
}