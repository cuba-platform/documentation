public class CurrencyFormatter implements Formatter<BigDecimal> {

    protected GeneralConfiguration generalConfiguration;
    protected Currency currentCurrency;

    public CurrencyFormatter(GeneralConfiguration generalConfiguration) {
        this.generalConfiguration = generalConfiguration;
        currentCurrency = generalConfiguration.getCurrency();
    }

    @Override
    public String format(BigDecimal value) {
        return currentCurrency.format(value);
    }
}