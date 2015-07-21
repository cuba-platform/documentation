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

        // (8) an exception occurs due to optimistic locking
        //     and commit will fail
        tx.commit();
    } finally {
      tx.end();
    }
}

void methodB() {
    Transaction tx = persistence.createTransaction();
    try {
        // (4) creating a new instance of EntityManager,
        //    as this is a new transaction
        EntityManager em = persistence.getEntityManager();

        // (5) loading an entity with the same identifier
        Employee employee = em.find(Employee.class, id);

        // (6) the field value is old because an old instance of the entity
        //     has been loaded from DB
        assertEquals("old name", employee.getName());

        employee.setName("name B");

        // (7) the changes are commited to DB, and the value of
        //     "name B" will now be in DB
        tx.commit();
    } finally {
      tx.end();
    }
}