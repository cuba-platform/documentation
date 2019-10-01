relatedEntitiesAPI.openRelatedScreen(ordersTable.getSelected(),
        Order.class, "customer",
        new RelatedEntitiesAPI.RelatedScreenDescriptor("sales_Customer.lookup", WindowManager.OpenType.DIALOG));