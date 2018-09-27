@Inject
private FieldGroup fieldGroup;

@Inject
private Datasource<Order> orderDs;

@Named("fieldGroup.customer")
private PickerField customerField;

public void init(Map<String, Object> params){
    Customer customer;
    // Get customer from component: not for common use
    Component component = fieldGroup.getFieldNN("customer").getComponentNN();
    customer = ((HasValue)component).getValue();
    // Get customer from component
    customer = customerField.getValue();
    // Get customer from datasource: recommended
    customer = orderDs.getItem().getCustomer();
}
