@Inject
private GroupTable<Customer> customersTable;
@Inject
private ScreenBuilders screenBuilders;

private void editSelectedEntity() {
    screenBuilders.editor(customersTable).build().show();
}

private void createNewEntity() {
    screenBuilders.editor(customersTable)
            .newEntity()
            .withInitializer(customer -> {          // lambda to initialize new instance
                customer.setName("New customer");
            })
            .withScreenClass(CustomerEdit.class)    // specific editor screen
            .withLaunchMode(OpenMode.DIALOG)        // open as modal dialog
            .build()
            .show();
}
