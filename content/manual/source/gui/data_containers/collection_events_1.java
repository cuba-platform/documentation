@Subscribe(id = "customersDc", target = Target.DATA_CONTAINER)
private void onCustomersDcCollectionChange(
        CollectionContainer.CollectionChangeEvent<Customer> event) {
    CollectionChangeType changeType = event.getChangeType(); // <1>
    Collection<? extends Customer> changes = event.getChanges(); // <2>
    // ...
}
