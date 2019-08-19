@Inject
private PickerField<Customer> pickerField;

protected String generateIcon(Customer customer) {
    return (customer!= null) ? "icons/chain.png" : "icons/cancel.png";
}

@Subscribe
private void onInit(InitEvent event) {
    pickerField.setOptionIconProvider(this::generateIcon);
}