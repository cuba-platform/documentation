@Install(to = "customerField.open", subject = "screenOptionsSupplier")
private ScreenOptions customerFieldOpenScreenOptionsSupplier() {
    return new MapScreenOptions(ParamsMap.of("someParameter", 10));
}
