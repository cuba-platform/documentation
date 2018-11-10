public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    private LookupScreens lookupScreens;
    @Inject
    private PickerField<User> userPickerField;

    @Subscribe("userPickerField.lookup")
    protected void onUserPickerFieldLookupActionPerformed(Action.ActionPerformedEvent event) {
        lookupScreens.builder(User.class, this)
                .withField(userPickerField)
                .withScreen("sec$User.browse")      // specific lookup screen
                .withLaunchMode(OpenMode.DIALOG)    // open as modal dialog
                .build()
                .show();
    }
