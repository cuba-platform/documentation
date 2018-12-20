@Inject
private GroupTable<Customer> customersTable;
@Inject
private ScreenBuilders screenBuilders;

private void createNewEntity() {
    screenBuilders.editor(customersTable)
            .newEntity()
            .build()
            .show();
}
