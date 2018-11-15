ordersGrid.getColumnNN("amount").setEditorFieldGenerator((datasource, property) -> {
    LookupField lookupField = uiComponents.create(LookupField.NAME);
    lookupField.setDatasource(datasource, property);
    lookupField.setOptionsList(Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN));

    return lookupField;
});