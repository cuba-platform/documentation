@Subscribe("customersTable")
protected void onCustomersTableSelection(Table.SelectionEvent<Customer> event) {
    notifications.create()
            .withCaption("You selected " + customerSelectionEvent.getSelected().size() + " customers")
            .show();
}