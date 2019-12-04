@Inject
private ScreenBuilders screenBuilders;
@Inject
private LookupPickerField<Customer> customerField;

@Subscribe("customerField.lookup")
public void onCustomerFieldLookup(Action.ActionPerformedEvent event) {
    screenBuilders.lookup(customerField)
            .withOpenMode(OpenMode.DIALOG)
            .withScreenClass(CustomerBrowse.class)
            .withSelectValidator(customerValidationContext -> {
                boolean valid = customerValidationContext.getSelectedItems().size() == 1;
                if (!valid) {
                    notifications.create().withCaption("Select a single customer").show();
                }
                return valid;

            })
            .build()
            .show();
}
