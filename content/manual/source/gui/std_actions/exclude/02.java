@Named("customersTable.exclude")
private ExcludeAction customersTableExclude;

@Subscribe
public void onInit(InitEvent event) {
    customersTableExclude.setConfirmation(true);
    customersTableExclude.setConfirmationTitle("Removing customer...");
    customersTableExclude.setConfirmationMessage("Do you really want to remove the customer from the list?");
}
