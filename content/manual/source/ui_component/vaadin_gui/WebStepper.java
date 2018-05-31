package com.company.addonguidemo.web.gui.components;

import com.company.addonguidemo.web.gui.components.Stepper;
import com.haulmont.cuba.web.gui.components.WebAbstractField;
import org.vaadin.risto.stepper.IntStepper;

// note that WebStepper should extend WebAbstractField
public class WebStepper extends WebAbstractField<IntStepper> implements Stepper {
    public WebStepper() {
        this.component = new org.vaadin.risto.stepper.IntStepper();
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