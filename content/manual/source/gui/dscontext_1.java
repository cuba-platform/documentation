protected Customer customer;

protected void createNewCustomer() {
    customer = new Customer();
    customer.setName("John Doe");
}

public void init(Map<String, Object> params) {
    getDsContext().addListener(new DsContext.CommitListenerAdapter() {
        @Override
        public void beforeCommit(CommitContext context) {
            if (customer != null){
                context.getCommitInstances().add(customer);
            }
        }
    });
}