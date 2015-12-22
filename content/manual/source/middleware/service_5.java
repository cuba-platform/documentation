@Inject
private OrderService orderService;

public void calculateTotals() {
    orderService.calculateTotals(order);
}