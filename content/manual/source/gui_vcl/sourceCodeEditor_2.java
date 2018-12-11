@Inject
private CheckBox highlightActiveLineCheck;
@Inject
private LookupField<HighlightMode> modeField;
@Inject
private CheckBox printMarginCheck;
@Inject
private CheckBox showGutterCheck;
@Inject
private SourceCodeEditor simpleCodeEditor;

@Subscribe
protected void onInit(InitEvent event) {
    highlightActiveLineCheck.setValue(simpleCodeEditor.isHighlightActiveLine());
    highlightActiveLineCheck.addValueChangeListener(e ->
            simpleCodeEditor.setHighlightActiveLine(Boolean.TRUE.equals(e.getValue())));

    printMarginCheck.setValue(simpleCodeEditor.isShowPrintMargin());
    printMarginCheck.addValueChangeListener(e ->
            simpleCodeEditor.setShowPrintMargin(Boolean.TRUE.equals(e.getValue())));

    showGutterCheck.setValue(simpleCodeEditor.isShowGutter());
    showGutterCheck.addValueChangeListener(e ->
            simpleCodeEditor.setShowGutter(Boolean.TRUE.equals(e.getValue())));

    Map<String, HighlightMode> modes = new HashMap<>();
    for (HighlightMode mode : SourceCodeEditor.Mode.values()) {
        modes.put(mode.toString(), mode);
    }

    modeField.setOptionsMap(modes);
    modeField.setValue(HighlightMode.TEXT);
    modeField.addValueChangeListener(e ->
            simpleCodeEditor.setMode(e.getValue()));
}