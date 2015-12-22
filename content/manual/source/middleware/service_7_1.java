// service interface
public interface SalesService {
    String NAME = "sample_SalesService";

    BigDecimal calculateSales(Object customerId);
}