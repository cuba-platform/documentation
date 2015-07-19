@Inject
private Datasource<Customer> customerDs;

...
public void init(Map<String, Object> params) {
    ...
    customerDs.addListener(new DatasourceListener<Customer>() {
        // listener methods implementation
    });
}