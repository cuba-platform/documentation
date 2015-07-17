@Named("orderFieldGroup.customer")
protected PickerField customerField;

@Override
public void init(Map<String, Object> params) {
    customerField.addOpenAction();
    customerField.removeAction(customerField.getAction(PickerField.ClearAction.NAME));
}