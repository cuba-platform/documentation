@Inject
private GroupTable<Customer> customersTable;

@Install(to = "customersTable.remove", subject = "enabledRule")
private boolean customersTableRemoveEnabledRule() {
    Set<Customer> customers = customersTable.getSelected();
    return canBeRemoved(customers);
}
