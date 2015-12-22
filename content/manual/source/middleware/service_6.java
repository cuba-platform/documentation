public void calculateTotals() {
    AppBeans.get(OrderService.class).calculateTotals(order);
}