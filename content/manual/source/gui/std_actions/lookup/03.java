@Install(to = "customerField.lookup", subject = "screenOptionsSupplier")
private ScreenOptions customerFieldLookupScreenOptionsSupplier() {
    return new MapScreenOptions(ParamsMap.of("someParameter", 10));
}
