@Named("fieldGroup.name")
private TextField nameField;

@Override
public void init(Map<String, Object> params) {
    nameField.setStyleName("name-field");
}