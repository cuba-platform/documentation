@Inject
private GroupTable<Customer> customersTable;
@Inject
private ScreenBuilders screenBuilders;

private void editSelectedEntity() {
    screenBuilders.editor(customersTable).build().show();
}
