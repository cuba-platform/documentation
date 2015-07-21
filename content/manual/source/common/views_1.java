View view = new View(Order.class)
        .addProperty("date")
        .addProperty("amount")
        .addProperty("customer", new View(Customer.class)
            .addProperty("name")
        );