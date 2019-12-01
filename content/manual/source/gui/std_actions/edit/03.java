@Install(to = "customersTable.edit", subject = "screenOptionsSupplier")
protected ScreenOptions customersTableEditScreenOptionsSupplier() {
    return new MapScreenOptions(ParamsMap.of("someParameter", 10));
}
