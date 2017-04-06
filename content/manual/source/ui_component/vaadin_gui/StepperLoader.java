package com.company.addonguidemo.gui.xml.layout.loaders;

import com.company.addonguidemo.gui.components.Stepper;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractFieldLoader;

public class StepperLoader extends AbstractFieldLoader<Stepper> {
    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(Stepper.class);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {

        String manualInput = element.attributeValue("manualInput");
        if (manualInput != null) {
            resultComponent.setManualInputAllowed(Boolean.valueOf(manualInput));
        }
        String mouseWheel = element.attributeValue("mouseWheel");
        if (mouseWheel != null) {
            resultComponent.setMouseWheelEnabled(Boolean.valueOf(mouseWheel));
        }
        String stepAmount = element.attributeValue("stepAmount");
        if (stepAmount != null) {
            resultComponent.setStepAmount(Integer.valueOf(stepAmount));
        }
        String maxValue = element.attributeValue("maxValue");
        if (maxValue != null) {
            resultComponent.setMaxValue(Integer.valueOf(maxValue));
        }
        String minValue = element.attributeValue("minValue");
        if (minValue != null) {
            resultComponent.setMinValue(Integer.valueOf(minValue));
        }
    }
}
