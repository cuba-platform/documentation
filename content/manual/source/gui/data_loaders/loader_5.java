@Subscribe(id = "customersDl", target = Target.DATA_LOADER)
private void onCustomersDlPreLoad(CollectionLoader.PreLoadEvent<Customer> event) {
    // do something before loading
}

@Subscribe(id = "customersDl", target = Target.DATA_LOADER)
private void onCustomersDlPostLoad(CollectionLoader.PostLoadEvent<Customer> event) {
    // do something after loading
}