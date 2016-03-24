package com.company.addonguidemo.gui.components;

import com.haulmont.cuba.gui.components.Field;

public interface Stepper extends Field {

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