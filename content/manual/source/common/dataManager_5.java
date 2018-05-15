List<KeyValueEntity> list = dataManager.loadValues(
        "select o.customer, sum(o.amount) from demo$Order o " +
        "where o.date >= :date group by o.customer")
    .properties("customer", "sum")
    .parameter("date", orderDate)
    .list();
