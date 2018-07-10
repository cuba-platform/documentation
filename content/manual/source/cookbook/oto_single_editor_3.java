@Inject
private Metadata metadata;

@Override
protected void initNewItem(Customer customer) {
    customer.setDetails(metadata.create(CustomerDetails.class));
}