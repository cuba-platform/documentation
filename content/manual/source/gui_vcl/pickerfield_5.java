@Inject
private ScreenBuilders screenBuilders;
@Inject
private PickerField<Color> pickerField;

@Subscribe("pickerField.lookup")
protected void onPickerFieldLookupActionPerformed(Action.ActionPerformedEvent event) {
        screenBuilders.lookup(pickerField)
                 .withScreenClass(CustomColorBrowser.class)
                 .build()
                 .show();
}