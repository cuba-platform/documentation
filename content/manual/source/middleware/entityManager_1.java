@Service(SalesService.NAME)
public class SalesServiceBean implements SalesService {

    @Inject
    private Persistence persistence;

    @Override
    public BigDecimal calculateSales(UUID customerId) {
        BigDecimal result;
        // start transaction
        try (Transaction tx = persistence.createTransaction()) {
            // get EntityManager for the current transaction
            EntityManager em = persistence.getEntityManager();
            // create and execute Query
            Query query = em.createQuery(
                    "select sum(o.amount) from sample_Order o where o.customer.id = :customerId");
            query.setParameter("customerId", customerId);
            result = (BigDecimal) query.getFirstResult();
            // commit transaction
            tx.commit();
        }
        return result != null ? result : BigDecimal.ZERO;
    }
}