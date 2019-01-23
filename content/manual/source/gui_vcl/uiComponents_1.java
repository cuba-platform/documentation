@Inject
private UiComponents uiComponents;

@Subscribe
protected void onInit(InitEvent event) {
    // components working with simple data types
    Label<String> label = uiComponents.create(Label.TYPE_STRING);
    TextField<Integer> amountField = uiComponents.create(TextField.TYPE_INTEGER);
    LookupField<String> stringLookupField = uiComponents.create(LookupField.TYPE_STRING);

    // components working with entities
    LookupField<Customer> customerLookupField = uiComponents.create(LookupField.of(Customer.class));
    PickerField<Customer> pickerField = uiComponents.create(PickerField.of(Customer.class));
    Table<OrderLine> table = uiComponents.create(Table.of(OrderLine.class));

    // other components and containers
    Button okButton = uiComponents.create(Button.class);
    VBoxLayout vBox = uiComponents.create(VBoxLayout.class);

    // ...
}