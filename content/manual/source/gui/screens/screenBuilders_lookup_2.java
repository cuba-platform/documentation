@Inject
private PickerField<User> userPickerField;
@Inject
private ScreenBuilders screenBuilders;

private void lookupUser() {
    screenBuilders.lookup(User.class, this)
            .withField(userPickerField)     // set result to the field
            .build()
            .show();
}