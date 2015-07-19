CollectionDatasource ds = new DsBuilder(getDsContext())
        .setJavaClass(Order.class)
        .setViewName(View.LOCAL)
        .setId("ordersDs")
        .buildCollectionDatasource();