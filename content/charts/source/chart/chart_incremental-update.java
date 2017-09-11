public class OrdersHistory extends AbstractWindow {
    @Inject
    private Metadata metadata;
    @Inject
    private TimeSource timeSource;
    @Inject
    private CollectionDatasource<Order, UUID> ordersDs;

    private Random random = new Random(42);

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        Order initialValue = metadata.create(Order.class);
        initialValue.setAmount(new BigDecimal(random.nextInt(1000) + 100));
        initialValue.setDate(timeSource.currentTimestamp());

        ordersDs.includeItem(initialValue);
    }

    public void updateChart(Timer source) {
        Order orderHistory = metadata.create(Order.class);
        orderHistory.setAmount(new BigDecimal(random.nextInt(1000) + 100));
        orderHistory.setDate(timeSource.currentTimestamp());;

        ordersDs.includeItem(orderHistory);
    }
}