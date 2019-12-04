@Named("customersTable.excel")
private ExcelAction customersTableExcel;

@Subscribe
public void onInit(InitEvent event) {
    customersTableExcel.setFileName("customers");
    customersTableExcel.setExportAggregation(false);
}
