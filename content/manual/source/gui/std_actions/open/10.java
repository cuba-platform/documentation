@Inject
private ScreenBuilders screenBuilders;
@Inject
private LookupPickerField<Customer> customerField;

@Subscribe("customerField.open")
public void onCustomerFieldOpen(Action.ActionPerformedEvent event) {
    screenBuilders.editor(customerField)
            .withOpenMode(OpenMode.DIALOG)
            .withScreenClass(CustomerEdit.class)
            .build()
            .show();
}
