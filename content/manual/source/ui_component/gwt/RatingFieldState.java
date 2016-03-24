package com.company.ratingsample.web.toolkit.ui.client.ratingfield;

import com.vaadin.shared.AbstractFieldState;

public class RatingFieldState extends AbstractFieldState {
    {   // change the main style name of the component
        primaryStyleName = "ratingfield";
    }
    // define a field for the value
    public int value = 0;
}