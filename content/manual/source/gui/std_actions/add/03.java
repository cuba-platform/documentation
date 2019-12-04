@Install(to = "customersTable.add", subject = "screenOptionsSupplier")
private ScreenOptions customersTableAddScreenOptionsSupplier() {
    return new MapScreenOptions(ParamsMap.of("someParameter", 10));
}
