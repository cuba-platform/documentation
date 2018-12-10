relatedEntitiesAPI.openRelatedScreen(ordersTable.getSelected(),
        Order.class, "customer",
        new RelatedEntitiesAPI.RelatedScreenDescriptor("sales$Customer.lookup", WindowManager.OpenType.DIALOG));