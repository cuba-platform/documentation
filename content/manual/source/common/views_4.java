// explicit view builder
dataManager.load(Order.class)
        .view(viewBuilder ->
            viewBuilder.addAll("date", "amount", "customer.name"))
        .list();

// implicit view builder
dataManager.load(Order.class)
        .viewProperties("date", "amount", "customer.name")
        .list();