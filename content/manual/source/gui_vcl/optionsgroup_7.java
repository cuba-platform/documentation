@Inject
protected OptionsGroup roleTypesField;

@Subscribe
protected void onInit(InitEvent event) {
    roleTypesField.setOptionsList(Arrays.asList(RoleType.values()));
}