public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    private LookupScreens lookupScreens;
    @Inject
    private TextField<String> userField;

    private void lookupUser() {
        lookupScreens.builder(User.class, this)
                .withScreen("sec$User.browse")          // specific lookup screen
                .withLaunchMode(OpenMode.DIALOG)        // open as modal dialog
                .withSelectHandler(users -> {
                    User user = users.iterator().next();
                    userField.setValue(user.getName());
                })
                .build()
                .show();
    }