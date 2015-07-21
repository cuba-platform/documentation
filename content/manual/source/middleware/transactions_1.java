@Inject
private Persistence persistence;
...
Transaction tx = persistence.createTransaction();
try {
    EntityManager em = persistence.getEntityManager();
    Customer customer = new Customer();
    customer.setName("John Smith");
    em.persist(customer);

    tx.commit();
} finally {
    tx.end();
}