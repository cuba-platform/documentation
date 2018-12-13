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
    Transaction tx = persistence.getTransaction();
    try {
        EntityManager em = persistence.getEntityManager(); <4>

        Employee employee = em.find(Employee.class, id); <5>

        assertEquals("name A", employee.getName()); <6>
        employee.setName("name B");

        tx.commit(); <7>
    } finally {
      tx.end();
    }
}