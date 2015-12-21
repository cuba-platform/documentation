protected Customer customer;

protected void createNewCustomer() {
    customer = metadata.create(Customer.class);
    customer.setName("John Doe");
}

@Override
public void init(Map<String, Object> params) {
    getDsContext().addBeforeCommitListener(context -> {
        if (customer != null)
            context.getCommitInstances().add(customer);
    }
}