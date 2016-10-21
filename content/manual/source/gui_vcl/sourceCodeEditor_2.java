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
    highlightActiveLineCheck.addValueChangeListener(e -> simpleCodeEditor.setHighlightActiveLine(Boolean.TRUE.equals(e.getValue())));

    printMarginCheck.setValue(simpleCodeEditor.isShowPrintMargin());
    printMarginCheck.addValueChangeListener(e -> simpleCodeEditor.setShowPrintMargin(Boolean.TRUE.equals(e.getValue())));

    showGutterCheck.setValue(simpleCodeEditor.isShowGutter());
    showGutterCheck.addValueChangeListener(e -> simpleCodeEditor.setShowGutter(Boolean.TRUE.equals(e.getValue())));

    Map<String, Object> modes = new HashMap<>();
    for (SourceCodeEditor.Mode mode : SourceCodeEditor.Mode.values()) {
        modes.put(mode.toString(), mode);
    }

    modeField.setOptionsMap(modes);
    modeField.setValue(SourceCodeEditor.Mode.Text);
    modeField.addValueChangeListener(e -> simpleCodeEditor.setMode((SourceCodeEditor.Mode) e.getValue()));
}