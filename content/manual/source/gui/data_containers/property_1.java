@Inject
private CollectionPropertyContainer<OrderLine> orderLinesDc;

private void filterByProduct(String product) {
    List<OrderLine> filtered = getEditedEntity().getOrderLines().stream()
            .filter(orderLine -> orderLine.getProduct().equals(product))
            .collect(Collectors.toList());
    orderLinesDc.setDisconnectedItems(filtered);
}

private void resetFilter() {
    orderLinesDc.setDisconnectedItems(getEditedEntity().getOrderLines());
}