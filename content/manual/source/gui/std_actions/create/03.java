@Install(to = "customersTable.create", subject = "screenOptionsSupplier")
protected ScreenOptions customersTableCreateScreenOptionsSupplier() {
    return new MapScreenOptions(ParamsMap.of("someParameter", 10));
}
