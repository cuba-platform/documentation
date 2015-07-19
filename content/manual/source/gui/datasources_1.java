@Inject
private FieldGroup fieldGroup;
@Inject
private Datasource<Order> orderDs;

public void init(Map<String, Object> params) {
    Customer customer;
    // Get customer from component
    customer = (Customer) fieldGroup.getFieldValue("customer");
    // Get customer from datasource
    customer = orderDs.getItem().getCustomer();
}