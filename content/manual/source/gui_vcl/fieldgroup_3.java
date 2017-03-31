@Inject
protected FieldGroup fieldGroup;
@Inject
protected ComponentsFactory componentsFactory;

@Override
public void init(Map<String, Object> params) {
        PasswordField passwordField = componentsFactory.createComponent(PasswordField.class);
        fieldGroup.getFieldNN("password").setComponent(passwordField);
}