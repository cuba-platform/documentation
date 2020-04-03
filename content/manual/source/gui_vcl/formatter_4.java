@Inject
private GroupTable<Order> ordersTable;

@Subscribe
public void onInit(InitEvent event) {
    Function currencyFormatter = new CurrencyFormatter();
    ordersTable.getColumn("totalPrice").setFormatter(currencyFormatter);
}