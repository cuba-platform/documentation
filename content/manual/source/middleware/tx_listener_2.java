@Component("demo_OrdersTransactionListener")
public class OrdersTransactionListener implements AfterCompleteTransactionListener {

    private Logger log = LoggerFactory.getLogger(OrdersTransactionListener.class);

    @Override
    public void afterComplete(boolean committed, Collection<Entity> detachedEntities) {
        if (!committed)
            return;

        for (Entity entity : detachedEntities) {
            if (entity instanceof Order) {
                log.info("Order: " + entity);
            }
        }
    }
}