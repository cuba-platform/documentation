@Inject
private TextField<String> userField;
@Inject
private ScreenBuilders screenBuilders;

private void lookupUser() {
    screenBuilders.lookup(User.class, this)
            .withSelectHandler(users -> {
                User user = users.iterator().next();
                userField.setValue(user.getName());
            })
            .build()
            .show();
}