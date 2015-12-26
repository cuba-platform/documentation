// service implementation
@Service(SalesService.NAME)
public class SalesServiceBean implements SalesService {

    @Inject
    private SalesCalculator salesCalculator;

    @Transactional
    @Override
    public BigDecimal calculateSales(UUID customerId) {
        return salesCalculator.calculateSales(customerId);
    }
}