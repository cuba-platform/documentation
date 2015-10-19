UUID customerId = persistence.createTransaction().execute((EntityManager em) -> {
    Customer customer = metadata.create(Customer.class);
    customer.setName("ABC");
    em.persist(customer);
    return customer.getId();
});

Customer customer = persistence.createTransaction().execute(em ->
        em.find(Customer.class, customerId, "_local"));
