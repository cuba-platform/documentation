// named parameter
dataManager.load(Customer.class)
        .query("e.name like :name")
        .parameter("name", value)
        .list();

// positional parameter
dataManager.load(Customer.class)
        .query("e.name like ?1", value)
        .list();

// case-insensitive positional parameter
dataManager.load(Customer.class)
        .query("e.name like ?1 or e.email like ?1", "(?i)%joe%")
        .list();

// multiple positional parameters
dataManager.load(Order.class)
        .query("e.date between ?1 and ?2", date1, date2)
        .list();

// omitting "select" and using a positional parameter
dataManager.load(Order.class)
        .query("from sales_Order o, sales_OrderLine l " +
                "where l.order = o and l.product.name = ?1", productName)
        .list();