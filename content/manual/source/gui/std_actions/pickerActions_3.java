public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private PickerField<User> userPickerField;

    @Subscribe("userPickerField.lookup")
    protected void onUserPickerFieldLookupActionPerformed(Action.ActionPerformedEvent event) {
        screenBuilders.lookup(User.class, this)
                .withField(userPickerField)
                .withScreenClass(UserBrowser.class) // specific lookup screen
                .withLaunchMode(OpenMode.DIALOG)    // open as modal dialog
                .build()
                .show();
    }
