@Named("customersTable.remove")
private RemoveAction customersTableRemove;

@Subscribe
public void onInit(InitEvent event) {
    customersTableRemove.setConfirmation(true);
    customersTableRemove.setConfirmationTitle("Removing customer...");
    customersTableRemove.setConfirmationMessage("Do you really want to remove the customer?");
}
