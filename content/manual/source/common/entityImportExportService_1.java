@Inject
private EntityImportExportService entityImportExportService;
@Inject
private GroupDatasource<Customer, UUID> customersDs;

...
String jsonFromDs = entityImportExportService.exportEntitiesToJSON(customersDs.getItems());