@Inject
protected FieldGroup fieldGroup;
@Inject
protected ComponentsFactory componentsFactory;

@Override
public void init(Map<String, Object> params) {
    fieldGroup.addCustomField("password", new FieldGroup.CustomFieldGenerator() {
        @Override
        public Component generateField(Datasource datasource, String propertyId) {
            PasswordField passwordField = componentsFactory.createComponent(PasswordField.class);
            passwordField.setDatasource(datasource, propertyId);
            return passwordField;
        }
    });
}