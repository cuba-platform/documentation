List<KeyValueEntity> list = dataManager.loadValues(
        "select o.customer, sum(o.amount) from demo_Order o " +
        "where o.date >= :date group by o.customer")
    .store("legacy_db") // <1>
    .properties("customer", "sum") // <2>
    .parameter("date", orderDate)
    .list();
