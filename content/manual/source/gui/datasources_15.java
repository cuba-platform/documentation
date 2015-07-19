@Inject
private Datasource<Customer> customerDs;

public void init(Map<String, Object> params) {
    ...
    customerDs.addListener(new DsListenerAdapter<Customer>() {
        @Override
        public void valueChanged(Customer source, String property, Object prevValue, Object value) {
            if ("active".equals(property)) {
                boolean active = BooleanUtils.isTrue((Boolean) value); // converting null to false
                updateSettings(active);
            }
        }
    });
}