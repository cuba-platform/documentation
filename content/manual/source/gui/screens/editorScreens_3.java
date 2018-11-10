public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    private EditorScreens editorScreens;
    @Inject
    private GroupTable<Customer> customersTable;

    private void createNewEntity() {
        editorScreens.builder(customersTable)
                .newEntity()
                .build()
                .show();
    }