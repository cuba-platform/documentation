public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    private EditorScreens editorScreens;
    @Inject
    private GroupTable<Customer> customersTable;

    private void createNewEntity() {
        editorScreens.builder(customersTable)
                .newEntity()
                .withInitializer(customer -> {          // lambda to initialize new instance
                    customer.setName("New customer");
                })
                .withScreen(CustomerEdit.class)         // specific editor screen
                .withLaunchMode(OpenMode.DIALOG)        // open as modal dialog
                .build()
                .show();
    }