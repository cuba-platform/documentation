@Inject
private CollectionPropertyContainer<OrderLine> orderLinesDc;

private void filterByProduct(String product) {
    orderLinesDc.getDisconnectedItems().removeIf(
            orderLine -> !orderLine.getProduct().equals(product));
}

private void resetFilter() {
    orderLinesDc.setDisconnectedItems(getEditedEntity().getOrderLines());
}