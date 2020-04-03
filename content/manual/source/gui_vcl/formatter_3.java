public class CurrencyFormatter implements Function<BigDecimal, String> {

    @Override
    public String apply(BigDecimal bigDecimal) {
        return NumberFormat.getCurrencyInstance(Locale.getDefault()).format(bigDecimal);
    }
}