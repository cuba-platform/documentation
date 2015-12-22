// managed bean encapsulating business logic
@Component
public class SalesCalculator {

    @Inject
    private Persistence persistence;

    public BigDecimal calculateSales(Object customerId) {
        Query query = persistence.getEntityManager().createQuery(
                "select sum(o.amount) from sample$Order o where o.customer.id = :customerId");
        query.setParameter("customerId", customerId);
        return (BigDecimal) query.getFirstResult();
    }
}