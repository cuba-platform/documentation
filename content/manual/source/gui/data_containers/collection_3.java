@Inject
private CollectionContainer<Customer> customersDc;
@Inject
private GroupTable<Customer> customersTable;

private void selectFirstRow() {
    customersTable.setSelected(customersDc.getItems().get(0));
}