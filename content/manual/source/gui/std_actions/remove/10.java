@Inject
private RemoveOperation removeOperation;

@Subscribe("customersTable.remove")
public void onCustomersTableRemove(Action.ActionPerformedEvent event) {
    removeOperation.builder(customersTable)
            .withConfirmationTitle("Removing customer...")
            .withConfirmationMessage("Do you really want to remove the customer?")
            .remove();
}
