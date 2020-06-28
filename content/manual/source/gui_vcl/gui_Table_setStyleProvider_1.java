@Inject
protected Table customersTable;

@Subscribe
protected void onInit(InitEvent event) {
    customersTable.setStyleProvider((customer, property) -> {
        if (property == null) {
            // style for row
            if (hasComplaints(customer)) {
                return "unsatisfied-customer";
            }
        } else if (property.equals("grade")) {
            // style for column "grade"
            switch (customer.getGrade()) {
                case PREMIUM: return "premium-grade";
                case HIGH: return "high-grade";
                case MEDIUM: return "medium-grade";
                default: return null;
            }
        }
        return null;
    });
}