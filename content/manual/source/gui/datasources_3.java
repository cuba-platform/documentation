@Override
public void init(Map<String, Object> params) {
    Set<Customer> entities = (Set<Customer>) params.get("customers");
    for (Customer entity : entities) {
        customersDs.includeItem(entity);
    }
    customersDs.refresh();
}