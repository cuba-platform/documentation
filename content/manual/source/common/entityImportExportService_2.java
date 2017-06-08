@Inject
private EntityImportExportService entityImportExportService;
@Inject
private GroupDatasource<Customer, UUID> customersDs;
@Inject
private Metadata metadata;
@Inject
private DataManager dataManager;

...
byte[] array = entityImportExportService.exportEntitiesToZIP(customersDs.getItems());
FileDescriptor descriptor = metadata.create(FileDescriptor.class);
descriptor.setName("customersDs.zip");
descriptor.setExtension("zip");
descriptor.setSize((long) array.length);
descriptor.setCreateDate(new Date());
try {
    fileLoader.saveStream(descriptor, () -> new ByteArrayInputStream(array));
} catch (FileStorageException e) {
    throw new RuntimeException(e);
}
dataManager.commit(descriptor);