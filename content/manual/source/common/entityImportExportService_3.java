@Inject
private EntityImportExportService entityImportExportService;
@Inject
private FileLoader fileLoader;

private FileDescriptor descriptor;

...
EntityImportView view = new EntityImportView(Customer.class);
view.addLocalProperties();
try {
    byte[] array = IOUtils.toByteArray(fileLoader.openStream(descriptor));
    Collection<Entity> collection = entityImportExportService.importEntitiesFromZIP(array, view);
} catch (FileStorageException e) {
    throw new RuntimeException(e);
}
