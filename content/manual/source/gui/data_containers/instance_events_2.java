@Subscribe(id = "customerDc", target = Target.DATA_CONTAINER)
private void onCustomerDcItemChange(InstanceContainer.ItemChangeEvent<Customer> event) {
    Customer customer = event.getItem();
    Customer previouslySelectedCustomer = event.getPrevItem();
    // ...
}
