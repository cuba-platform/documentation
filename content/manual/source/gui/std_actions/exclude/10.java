@Inject
private RemoveOperation removeOperation;

@Subscribe("customersTable.exclude")
public void onCustomersTableExclude(Action.ActionPerformedEvent event) {
    removeOperation.builder(customersTable)
            .withConfirmationMessage("Do you really want to remove the customer from the list?")
            .withConfirmationTitle("Removing customer...")
            .exclude();
}
