TypedQuery<Customer> query = em.createNativeQuery(
    "select * from SALES_CUSTOMER where NAME like ?1",
    Customer.class);
query.setParameter(1, "%Company%");
List<Customer> list = query.getResultList();