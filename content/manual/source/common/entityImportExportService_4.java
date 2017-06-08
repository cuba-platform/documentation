@Inject
private EntityImportExportService entityImportExportService;
@Inject
private GroupDatasource<Customer, UUID> customersDs;

...
EntityImportView view = new EntityImportView(Customer.class);
view.addLocalProperties();
Collection<Entity> collection = entityImportExportService.importEntities(customersDs.getItems(), view);