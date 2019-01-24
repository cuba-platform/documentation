package com.company.ratingsample.web.toolkit.ui.client.ratingfield;

import com.company.ratingsample.web.toolkit.ui.RatingFieldServerComponent;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.shared.ui.Connect;

// link the connector with the server implementation of RatingField
// extend AbstractField connector
@Connect(RatingFieldServerComponent.class)
public class RatingFieldConnector extends AbstractFieldConnector {

    // we will use a RatingFieldWidget widget
    @Override
    public RatingFieldWidget getWidget() {
        RatingFieldWidget widget = (RatingFieldWidget) super.getWidget();

        if (widget.listener == null) {
            widget.listener = value ->
                    getRpcProxy(RatingFieldServerRpc.class).starClicked(value);
        }
        return widget;
    }

    // our state class is RatingFieldState
    @Override
    public RatingFieldState getState() {
        return (RatingFieldState) super.getState();
    }

    // react on server state change
    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        // refresh the widget if the value on server has changed
        if (stateChangeEvent.hasPropertyChanged("value")) {
            getWidget().setValue(getState().value);
        }
    }
}