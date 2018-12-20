@Inject
private TextField<String> userField;
@Inject
private ScreenBuilders screenBuilders;

private void lookupUser() {
    screenBuilders.lookup(User.class, this)
            .withScreenId("sec$User.browse")          // specific lookup screen
            .withLaunchMode(OpenMode.DIALOG)        // open as modal dialog
            .withSelectHandler(users -> {
                User user = users.iterator().next();
                userField.setValue(user.getName());
            })
            .build()
            .show();
}