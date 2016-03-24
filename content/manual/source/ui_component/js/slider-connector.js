com_company_jscomponent_web_toolkit_ui_slider_SliderServerComponent = function() {
    var connector = this;
    var element = connector.getElement();
    $(element).html("<div/>");
    $(element).css("padding", "5px 10px");

    var slider = $("div", element).slider({
        range: true,
        slide: function(event, ui) {
            connector.valueChanged(ui.values);
        }
    });

    connector.onStateChange = function() {
        var state = connector.getState();
        slider.slider("values", state.values);
        slider.slider("option", "min", state.minValue);
        slider.slider("option", "max", state.maxValue);
        element.width(state.width);
    }
}