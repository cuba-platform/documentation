createAction.setWindowParamsSupplier(() -> {
   Customer customer = metadata.create(Customer.class);
   customer.setCategory(/* some value dependent on the current state of the screen */);
   return ParamsMap.of("customer", customer);
});