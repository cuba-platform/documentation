@Inject
private PivotTable pivotTable;

private PivotTableExtension extension;

@Subscribe
private void onInit(InitEvent event) {
    extension = new WebPivotTableExtension(pivotTable)
}