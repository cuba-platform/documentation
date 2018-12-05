@Inject
private LookupScreens lookupScreens;
@Inject
private PickerField<Color> pickerField;

@Subscribe("pickerField.lookup")
protected void onPickerFieldLookupActionPerformed(Action.ActionPerformedEvent event) {
    lookupScreens.builder(pickerField)
                 .withScreen("custom-lookup")
                 .build()
                 .show();
}