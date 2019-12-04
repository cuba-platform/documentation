@Install(to = "customersTable.add", subject = "selectValidator")
private boolean customersTableAddSelectValidator(LookupScreen.ValidationContext<Customer> validationContext) {
    boolean valid = checkCustomers(validationContext.getSelectedItems());
    if (!valid) {
        notifications.create().withCaption("Selection is not valid").show();
    }
    return valid;
}