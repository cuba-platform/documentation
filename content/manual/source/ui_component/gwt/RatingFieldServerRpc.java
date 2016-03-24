package com.company.ratingsample.web.toolkit.ui.client.ratingfield;

import com.vaadin.shared.communication.ServerRpc;

public interface RatingFieldServerRpc extends ServerRpc {
    //method will be invoked in the client code
    void starClicked(int value);
}