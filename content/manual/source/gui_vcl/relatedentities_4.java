relatedEntitiesAPI.openRelatedScreen(ordersTable.getSelected(),
        Order.class, "customer",
        new RelatedScreenDescriptor("sales$Customer.lookup", OpenType.DIALOG));