public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    private LookupScreens lookupScreens;
    @Inject
    private PickerField<User> userPickerField;

    private void lookupUser() {
        lookupScreens.builder(User.class, this)
                .withField(userPickerField)     // set result to the field
                .build()
                .show();
    }