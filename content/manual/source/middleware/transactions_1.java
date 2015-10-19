@Inject
private Metadata metadata;
@Inject
private Persistence persistence;
...
// try-with-resources style
try (Transaction tx = persistence.createTransaction()) {
    Customer customer = metadata.create(Customer.class);
    customer.setName("John Smith");
    persistence.getEntityManager().persist(customer);
    tx.commit();
}
// plain style
Transaction tx = persistence.createTransaction();
try {
    Customer customer = metadata.create(Customer.class);
    customer.setName("John Smith");
    persistence.getEntityManager().persist(customer);
    tx.commit();
} finally {
    tx.end();
}