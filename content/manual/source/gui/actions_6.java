@Named("customersTable.copy")
private Action customersTableCopy;

@Inject
private PickerField<User> userPickerField;

@Subscribe
protected void onBeforeShow(BeforeShowEvent event) {
    customersTableCopy.setEnabled(false);
    userPickerField.getActionNN("show").setEnabled(false);
}