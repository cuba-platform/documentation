public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    private GroupTable<Customer> customersTable;
    @Inject
    private ScreenBuilders screenBuilders;

    @Subscribe("customersTable.create")
    protected void onCustomersTableCreateActionPerformed(Action.ActionPerformedEvent event) {
        screenBuilders.editor(customersTable)
                .newEntity()
                .withScreenClass(CustomerEdit.class)     // specific editor screen
                .withLaunchMode(OpenMode.DIALOG)        // open as modal dialog
                .build()
                .show();
    }
}