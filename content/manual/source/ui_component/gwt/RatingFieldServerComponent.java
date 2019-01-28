package com.company.ratingsample.web.toolkit.ui;

import com.company.ratingsample.web.toolkit.ui.client.ratingfield.RatingFieldServerRpc;
import com.company.ratingsample.web.toolkit.ui.client.ratingfield.RatingFieldState;
import com.vaadin.ui.AbstractField;

// the field will have a value with integer type
public class RatingFieldServerComponent extends AbstractField<Integer> {

    public RatingFieldServerComponent() {
        // register an interface implementation that will be invoked on a request from the client
        registerRpc((RatingFieldServerRpc) value -> setValue(value, true));
    }

    @Override
    protected void doSetValue(Integer value) {
        if (value == null) {
            value = 0;
        }
        getState().value = value;
    }

    @Override
    public Integer getValue() {
        return getState().value;
    }

    // define own state class
    @Override
    protected RatingFieldState getState() {
        return (RatingFieldState) super.getState();
    }

    @Override
    protected RatingFieldState getState(boolean markAsDirty) {
        return (RatingFieldState) super.getState(markAsDirty);
    }
}