@Named("customersTable.bulkEdit")
private BulkEditAction customersTableBulkEdit;

@Subscribe
public void onInit(InitEvent event) {
    customersTableBulkEdit.setOpenMode(OpenMode.THIS_TAB);
    customersTableBulkEdit.setIncludeProperties(Arrays.asList("name", "email"));
    customersTableBulkEdit.setColumnsMode(ColumnsMode.ONE_COLUMN);
}
