void methodA() {
    Transaction tx = persistence.createTransaction();
    try {
        EntityManager em = persistence.getEntityManager();

        Employee employee = em.find(Employee.class, id); <1>
        assertEquals("old name", employee.getName());

        employee.setName("name A"); <2>

        methodB(); <3>

        tx.commit(); <8>
    } finally {
      tx.end();
    }
}

void methodB() {
    Transaction tx = persistence.createTransaction();
    try {
        EntityManager em = persistence.getEntityManager(); <4>

        Employee employee = em.find(Employee.class, id); <5>

        assertEquals("old name", employee.getName()); <6>

        employee.setName("name B"); <7>

        tx.commit();
    } finally {
      tx.end();
    }
}