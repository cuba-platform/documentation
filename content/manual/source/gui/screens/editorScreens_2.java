public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    private EditorScreens editorScreens;
    @Inject
    private GroupTable<Customer> customersTable;

    private void editSelectedEntity() {
        editorScreens.builder(customersTable).build().show();
    }