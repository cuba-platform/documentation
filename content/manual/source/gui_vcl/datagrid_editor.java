@Inject
private DataGrid<Order> ordersDataGrid;
@Inject
private UiComponents uiComponents;

@Subscribe
protected void onInit(InitEvent event) {
    ordersDataGrid.getColumnNN("amount").setEditFieldGenerator(orderEditorFieldGenerationContext -> {
        LookupField<BigDecimal> lookupField = uiComponents.create(LookupField.NAME);
        lookupField.setValueSource((ValueSource<BigDecimal>) orderEditorFieldGenerationContext
                .getValueSourceProvider().getValueSource("amount"));
        lookupField.setOptionsList(Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN));

        return lookupField;
    });
}