@Inject
private Table<Customer> customersTable;
@Inject
private Notifications notifications;

@Subscribe
protected void onInit(InitEvent event) {
    customersTable.setCellClickListener("name", customerCellClickEvent ->
            notifications.create()
                    .withCaption(customerCellClickEvent.getItem().getName())
                    .show());
}