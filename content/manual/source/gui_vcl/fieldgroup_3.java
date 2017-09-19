@Inject
protected FieldGroup fieldGroup;
@Inject
protected ComponentsFactory componentsFactory;
@Inject
private Datasource<User> userDs;

@Override
public void init(Map<String, Object> params) {
        PasswordField passwordField = componentsFactory.createComponent(PasswordField.class);
        passwordField.setDatasource(userDs, "password");
        fieldGroup.getFieldNN("password").setComponent(passwordField);
}