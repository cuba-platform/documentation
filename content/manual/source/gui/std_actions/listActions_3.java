public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    private EditorScreens editorScreens;
    @Inject
    private GroupTable<Customer> customersTable;

    @Subscribe("customersTable.create")
    protected void onCustomersTableCreateActionPerformed(Action.ActionPerformedEvent event) {
        editorScreens.builder(customersTable)
                .newEntity()
                .withScreen(CustomerEdit.class)         // specific editor screen
                .withLaunchMode(OpenMode.DIALOG)        // open as modal dialog
                .build()
                .show();
    }