ValueLoadContext context = ValueLoadContext.create()
        .setQuery(ValueLoadContext.createQuery(
                    "select o.customer, sum(o.amount) from demo$Order o " +
                    "where o.date >= :date group by o.customer")
            .setParameter("date", orderDate))
        .addProperty("customer")
        .addProperty("sum");
List<KeyValueEntity> list = dataManager.loadValues(context);
