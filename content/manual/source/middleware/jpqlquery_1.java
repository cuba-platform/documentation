Customer customer = ...;
TypedQuery<Order> query = entityManager.createQuery(
    "select o from sales_Order o where o.customer.id = ?1", Order.class);
query.setParameter(1, customer);