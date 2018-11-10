public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    private EditorScreens editorScreens;

    private void editSelectedEntity(Customer entity) {
        editorScreens.builder(Customer.class, this)
                .editEntity(entity)
                .build()
                .show();
    }