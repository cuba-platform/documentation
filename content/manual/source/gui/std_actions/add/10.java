@Inject
private ScreenBuilders screenBuilders;
@Inject
private Table<Customer> customersTable;

@Subscribe("customersTable.add")
public void onCustomersTableAdd(Action.ActionPerformedEvent event) {
    screenBuilders.lookup(customersTable)
            .withOpenMode(OpenMode.DIALOG)
            .withScreenClass(CustomerBrowse.class)
            .withSelectValidator(customerValidationContext -> {
                boolean valid = checkCustomers(customerValidationContext.getSelectedItems());
                if (!valid) {
                    notifications.create().withCaption("Selection is not valid").show();
                }
                return valid;

            })
            .build()
            .show();
}
