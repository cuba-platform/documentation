ordersGrid.getColumnNN("amount").setEditorFieldGenerator((datasource, property) -> {
    LookupField lookupField = componentsFactory.createComponent(LookupField.class);
    lookupField.setDatasource(datasource, property);
    lookupField.setOptionsList(Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN));

    return lookupField;
});