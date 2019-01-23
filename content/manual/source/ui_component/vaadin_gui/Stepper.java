package com.company.demo.web.gui.components;

import com.haulmont.cuba.gui.components.Field;

// note that Stepper should extend Field
public interface Stepper extends Field<Integer> {

    String NAME = "stepper";

    boolean isManualInputAllowed();
    void setManualInputAllowed(boolean value);

    boolean isMouseWheelEnabled();
    void setMouseWheelEnabled(boolean value);

    int getStepAmount();
    void setStepAmount(int amount);

    int getMaxValue();
    void setMaxValue(int maxValue);

    int getMinValue();
    void setMinValue(int minValue);
}