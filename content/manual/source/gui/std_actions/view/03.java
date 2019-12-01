@Install(to = "customersTable.view", subject = "screenOptionsSupplier")
protected ScreenOptions customersTableViewScreenOptionsSupplier() {
    return new MapScreenOptions(ParamsMap.of("someParameter", 10));
}
