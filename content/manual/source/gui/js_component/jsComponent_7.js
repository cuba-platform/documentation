com_company_demo_web_screens_Sandbox = function () {
    var connector = this;
    var element = connector.getElement();
    element.innerHTML = "<div id=\"editor\">" +
        "<p>Hello World!</p>" +
        "<p>Some initial <strong>bold</strong> text</p>" +
        "<p><br></p>" +
        "</div>";

    connector.onStateChange = function () {
        var state = connector.getState();
        var data = state.data;

        var quill = new Quill('#editor', data.options);

        // Subscribe on textChange event
        quill.on('text-change', function (delta, oldDelta, source) {
            if (source === 'user') {
                connector.valueChanged(quill.getText(), quill.getContents());
            }
        });
    }
};