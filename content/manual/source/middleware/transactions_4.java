void methodA() {
    Transaction tx = persistence.createTransaction();
    try {
        EntityManager em = persistence.getEntityManager();

        // (1) loading an entity with name == "old name"
        Employee employee = em.find(Employee.class, id);
        assertEquals("old name", employee.getName());

        // (2) setting new value to the field
        employee.setName("name A");

        // (3) calling a method creating a nested transaction
        methodB();

        // (8) the changes are committed to DB, and
        //     it will contain "name B"
        tx.commit();
    } finally {
      tx.end();
    }
}

void methodB() {
    Transaction tx = persistence.getTransaction();
    try {
        // (4) retrieving the same instance of EntityManager as methodA
        EntityManager em = persistence.getEntityManager();

        // (5) loading an entity with the same identifier
        Employee employee = em.find(Employee.class, id);

        // (6) the field value is the new one since we are working with the same
        //     persistent context, and there are no calls to DB at all
        assertEquals("name A", employee.getName());
        employee.setName("name B");

        // (7) no actual commit is done at this point
        tx.commit();
    } finally {
      tx.end();
    }
}