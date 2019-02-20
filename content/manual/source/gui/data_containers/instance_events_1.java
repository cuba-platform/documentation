@Subscribe(id = "customerDc", target = Target.DATA_CONTAINER)
private void onCustomerDcItemPropertyChange(
        InstanceContainer.ItemPropertyChangeEvent<Customer> event) {
    Customer customer = event.getItem();
    String changedProperty = event.getProperty();
    Object currentValue = event.getValue();
    Object previousValue = event.getPrevValue();
    // ...
}