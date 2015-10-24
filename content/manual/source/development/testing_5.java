public class CustomerLoadTest {

    @ClassRule
    public static SalesTestContainer cont = new SalesTestContainer();

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = cont.persistence().createTransaction().execute(em -> {
            Customer customer = new Customer();
            customer.setName("testCustomer");
            em.persist(customer);
            return customer;
        });
    }

    @After
    public void tearDown() throws Exception {
        cont.deleteRecord(customer);
    }

    @Test
    public void test() {
        try (Transaction tx = cont.persistence().createTransaction()) {
            EntityManager em = cont.persistence().getEntityManager();
            TypedQuery<Customer> query = em.createQuery(
                "select c from sales$Customer c", Customer.class);
            List<Customer> list = query.getResultList();
            tx.commit();
            assertTrue(list.size() > 0);
        }
    }
}

