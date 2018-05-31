package com.company.addonguidemo.web.gui.xml.layout.loaders;

import com.company.addonguidemo.web.gui.components.Stepper;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractFieldLoader;

public class StepperLoader extends AbstractFieldLoader<Stepper> {
    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(Stepper.class);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {

        super.loadComponent();

        String manualInput = element.attributeValue("manualInput");
        if (manualInput != null) {
            resultComponent.setManualInputAllowed(Boolean.parseBoolean(manualInput));
        }
        String mouseWheel = element.attributeValue("mouseWheel");
        if (mouseWheel != null) {
            resultComponent.setMouseWheelEnabled(Boolean.parseBoolean(mouseWheel));
        }
        String stepAmount = element.attributeValue("stepAmount");
        if (stepAmount != null) {
            resultComponent.setStepAmount(Integer.parseInt(stepAmount));
        }
        String maxValue = element.attributeValue("maxValue");
        if (maxValue != null) {
            resultComponent.setMaxValue(Integer.parseInt(maxValue));
        }
        String minValue = element.attributeValue("minValue");
        if (minValue != null) {
            resultComponent.setMinValue(Integer.parseInt(minValue));
        }
    }
}
