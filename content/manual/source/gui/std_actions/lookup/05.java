@Install(to = "customerField.lookup", subject = "selectValidator")
private boolean customerFieldLookupSelectValidator(LookupScreen.ValidationContext<Customer> validationContext) {
    boolean valid = validationContext.getSelectedItems().size() == 1;
    if (!valid) {
        notifications.create().withCaption("Select a single customer").show();
    }
    return valid;
}
