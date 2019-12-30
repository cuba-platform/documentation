View view = ViewBuilder.of(Order.class)
        .addAll("date", "amount", "customer.name")
        .build();