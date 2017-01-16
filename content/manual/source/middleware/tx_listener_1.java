@Component("demo_OrdersTransactionListener")
public class OrdersTransactionListener implements BeforeCommitTransactionListener {

    @Inject
    private PersistenceTools persistenceTools;

    @Override
    public void beforeCommit(EntityManager entityManager, Collection<Entity> managedEntities) {
        // gather all orders affected by changes in the current transaction
        Set<Order> affectedOrders = new HashSet<>();

        for (Entity entity : managedEntities) {
            // skip not modified entities
            if (!persistenceTools.isDirty(entity))
                continue;

            if (entity instanceof Order)
                affectedOrders.add((Order) entity);
            else if (entity instanceof OrderLine) {
                Order order = ((OrderLine) entity).getOrder();
                // a reference can be detached, so merge it into current persistence context
                affectedOrders.add(entityManager.merge(order));
            }
        }
        // calculate amount for each affected order by its lines and discount
        for (Order order : affectedOrders) {
            BigDecimal amount = BigDecimal.ZERO;
            for (OrderLine orderLine : order.getOrderLines()) {
                if (!orderLine.isDeleted()) {
                    amount = amount.add(orderLine.getPrice().multiply(orderLine.getQuantity()));
                }
            }
            BigDecimal discount = order.getDiscount().divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_DOWN);
            order.setAmount(amount.subtract(amount.multiply(discount)));
        }
    }
}