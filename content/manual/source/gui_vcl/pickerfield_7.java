@Inject
private PickerField<Customer> pickerField;

@Subscribe("pickerField.show")
protected void onPickerFieldShowActionPerformed(Action.ActionPerformedEvent event) {
    CustomerEdit customerEdit = screenBuilders.editor(pickerField)
            .withScreenClass(CustomerEdit.class)
            .build();
    customerEdit.setDiscount(true);
    customerEdit.show();
}