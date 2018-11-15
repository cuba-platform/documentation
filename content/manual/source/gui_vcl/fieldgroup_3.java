@Inject
protected FieldGroup fieldGroup;
@Inject
protected UiComponents uiComponents;
@Inject
private Datasource<User> userDs;

@Override
public void init(Map<String, Object> params) {
    PasswordField passwordField = uiComponents.create(PasswordField.NAME);
    passwordField.setDatasource(userDs, "password");
    fieldGroup.getFieldNN("password").setComponent(passwordField);
}