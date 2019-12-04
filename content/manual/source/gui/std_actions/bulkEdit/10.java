@Inject
private BulkEditors bulkEditors;
@Inject
private GroupTable<Customer> customersTable;

@Subscribe("customersTable.bulkEdit")
public void onCustomersTableBulkEdit(Action.ActionPerformedEvent event) {
    bulkEditors.builder(metadata.getClassNN(Customer.class), customersTable.getSelected(), this)
            .withListComponent(customersTable)
            .withColumnsMode(ColumnsMode.ONE_COLUMN)
            .withIncludeProperties(Arrays.asList("name", "email"))
            .create()
            .show();
}
