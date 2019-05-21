package com.company.demo.web.components.stepper;

import com.google.common.base.Strings;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractFieldLoader;

public class StepperFieldLoader extends AbstractFieldLoader<StepperField> { // <1>

    @Override
    public void createComponent() {
        resultComponent = factory.create(StepperField.NAME); // <2>
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
        super.loadComponent();
        String incrementStr = element.attributeValue("step"); // <3>
        if (!Strings.isNullOrEmpty(incrementStr)) {
            resultComponent.setStep(Integer.parseInt(incrementStr));
        }
    }
}