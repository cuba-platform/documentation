public void updateChart(Timer source) {
    Order orderHistory = metadata.create(Order.class);
    orderHistory.setAmount(new BigDecimal(random.nextInt(1000) + 100));
    orderHistory.setDate(timeSource.currentTimestamp());;

    ordersDs.includeItem(orderHistory);

    itemsQueue.add(orderHistory);

    if (itemsQueue.size() > 10) {
        Order item = itemsQueue.poll();
        ordersDs.excludeItem(item);
    }
}