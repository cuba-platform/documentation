@Inject
protected OptionsGroup roleTypesField;

@Override
public void init(Map<String, Object> params) {
    roleTypesField.setOptionsList(Arrays.asList(RoleType.values()));
}