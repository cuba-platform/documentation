protected void initTableColumns() {
    Formatter<BigDecimal> currencyFormatter = new CurrencyFormatter(generalConfiguration);
    table.getColumn("totalPrice").setFormatter(currencyFormatter);
}