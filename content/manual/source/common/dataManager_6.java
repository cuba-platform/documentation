BigDecimal sum = dataManager.loadValue(
        "select sum(o.amount) from demo_Order o " +
        "where o.date >= :date group by o.customer", BigDecimal.class)
    .store("legacy_db") // <1>
    .parameter("date", orderDate)
    .one();
