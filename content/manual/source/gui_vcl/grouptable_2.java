@Inject
private GroupTable<Customer> customerTable;

@Subscribe
public void onInit(InitEvent event) {
    customerTable.setStyleProvider(new GroupTable.GroupStyleProvider<Customer>() {

        @SuppressWarnings("unchecked")
        @Override
        public String getStyleName(GroupInfo info) {
            CustomerGrade grade = (CustomerGrade) info.getPropertyValue(info.getProperty());
            switch (grade) {
                case PREMIUM:
                    return "premium-grade";
                case HIGH:
                    return "high-grade";
                case STANDARD:
                    return "standard-grade";
            }
            return null;
        }

        @Override
        public String getStyleName(Customer customer, @Nullable String property) {
            if (Boolean.TRUE.equals(customer.getActive())) {
                return "active-customer";
            }
            return null;
        }
    });
}