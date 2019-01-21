package com.company.demo.web.gui.components;

import com.haulmont.cuba.web.gui.components.WebV8AbstractField;
import org.vaadin.risto.stepper.IntStepper;

// note that WebStepper should extend WebAbstractField
public class WebStepper extends WebV8AbstractField<IntStepper, Integer, Integer> implements Stepper {

    public WebStepper() {
        this.component = createComponent();

        attachValueChangeListener(component);
    }

    private IntStepper createComponent() {
        return new IntStepper();
    }

    @Override
    public boolean isManualInputAllowed() {
        return component.isManualInputAllowed();
    }

    @Override
    public void setManualInputAllowed(boolean value) {
        component.setManualInputAllowed(value);
    }

    @Override
    public boolean isMouseWheelEnabled() {
        return component.isMouseWheelEnabled();
    }

    @Override
    public void setMouseWheelEnabled(boolean value) {
        component.setMouseWheelEnabled(value);
    }

    @Override
    public int getStepAmount() {
        return component.getStepAmount();
    }

    @Override
    public void setStepAmount(int amount) {
        component.setStepAmount(amount);
    }

    @Override
    public int getMaxValue() {
        return component.getMaxValue();
    }

    @Override
    public void setMaxValue(int maxValue) {
        component.setMaxValue(maxValue);
    }

    @Override
    public int getMinValue() {
        return component.getMinValue();
    }

    @Override
    public void setMinValue(int minValue) {
        component.setMinValue(minValue);
    }
}