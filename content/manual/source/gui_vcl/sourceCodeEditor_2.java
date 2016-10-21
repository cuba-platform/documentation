@Inject
private LookupField modeField;
@Inject
private SourceCodeEditor simpleCodeEditor;
@Inject
private CheckBox highlightActiveLineCheck;
@Inject
private CheckBox printMarginCheck;
@Inject
private CheckBox showGutterCheck;

@Override
public void init(Map<String, Object> params) {
    highlightActiveLineCheck.setValue(simpleCodeEditor.isHighlightActiveLine());
    highlightActiveLineCheck.addValueChangeListener(e -> {
        if (e.getValue() != null) {
            simpleCodeEditor.setHighlightActiveLine((Boolean) e.getValue());
        }
    });

    printMarginCheck.setValue(simpleCodeEditor.isShowPrintMargin());
    printMarginCheck.addValueChangeListener(e -> {
        if (e.getValue() != null) {
            simpleCodeEditor.setShowPrintMargin((Boolean) e.getValue());
        }
    });

    showGutterCheck.setValue(simpleCodeEditor.isShowGutter());
    showGutterCheck.addValueChangeListener(e -> {
        if (e.getValue() != null) {
            simpleCodeEditor.setShowGutter((Boolean) e.getValue());
        }
    });

    Map<String, Object> modes = new HashMap<>();
    for (SourceCodeEditor.Mode mode : SourceCodeEditor.Mode.values()) {
        modes.put(mode.toString(), mode);
    }

    modeField.setOptionsMap(modes);
    modeField.setValue(SourceCodeEditor.Mode.Text);
    modeField.addValueChangeListener(e -> {
        if (e.getValue() != null) {
            simpleCodeEditor.setMode((SourceCodeEditor.Mode) e.getValue());
        }
    });
}