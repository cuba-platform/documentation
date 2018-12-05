@Inject
private PickerField<Customer> pickerField;

@Subscribe("pickerField.show")
protected void onPickerFieldShowActionPerformed(Action.ActionPerformedEvent event) {
    CustomerEdit customerEdit = editorScreens.builder(pickerField)
            .withScreen(CustomerEdit.class)
            .build();
    customerEdit.setDiscount(true);
    customerEdit.show();
}