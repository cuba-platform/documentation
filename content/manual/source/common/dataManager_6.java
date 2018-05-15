BigDecimal sum = dataManager.loadValue(
        "select sum(o.amount) from demo$Order o " +
        "where o.date >= :date group by o.customer", BigDecimal.class)
    .parameter("date", orderDate)
    .one();
