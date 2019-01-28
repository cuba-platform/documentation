package com.company.ratingsample.web.toolkit.ui.client.ratingfield;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FocusWidget;

import java.util.ArrayList;
import java.util.List;

public class RatingFieldWidget extends FocusWidget {

    private static final String CLASSNAME = "ratingfield";

    // API for handle clicks
    public interface StarClickListener {
        void starClicked(int value);
    }

    protected List<SpanElement> stars = new ArrayList<>(5);
    protected StarClickListener listener;
    protected int value = 0;

    public RatingFieldWidget() {
        DivElement container = DOM.createDiv().cast();
        container.getStyle().setDisplay(Display.INLINE_BLOCK);
        for (int i = 0; i < 5; i++) {
            SpanElement star = DOM.createSpan().cast();

            // add star element to the container
            DOM.insertChild(container, star, i);
            // subscribe on ONCLICK event
            DOM.sinkEvents(star, Event.ONCLICK);

            stars.add(star);
        }
        setElement(container);

        setStylePrimaryName(CLASSNAME);
    }

    // main method for handling events in GWT widgets
    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);

        switch (event.getTypeInt()) {
            // react on ONCLICK event
            case Event.ONCLICK:
                SpanElement element = event.getEventTarget().cast();
                // if click was on the star
                int index = stars.indexOf(element);
                if (index >= 0) {
                    int value = index + 1;
                    // set internal value
                    setValue(value);

                    // notify listeners
                    if (listener != null) {
                        listener.starClicked(value);
                    }
                }
                break;
        }
    }

    @Override
    public void setStylePrimaryName(String style) {
        super.setStylePrimaryName(style);

        for (SpanElement star : stars) {
            star.setClassName(style + "-star");
        }

        updateStarsStyle(this.value);
    }

    // let application code change the state
    public void setValue(int value) {
        this.value = value;
        updateStarsStyle(value);
    }

    // refresh visual representation
    private void updateStarsStyle(int value) {
        for (SpanElement star : stars) {
            star.removeClassName(getStylePrimaryName() + "-star-selected");
        }

        for (int i = 0; i < value; i++) {
            stars.get(i).addClassName(getStylePrimaryName() + "-star-selected");
        }
    }
}