@Inject
private CheckBox accessField;

@Override
public void init(Map<String, Object> params) {
    accessField.addValueChangeListener(event -> {
        if (Boolean.TRUE.equals(event.getValue())) {
            showNotification("set", NotificationType.HUMANIZED);
        } else {
            showNotification("not set", NotificationType.HUMANIZED);
        }
    });
}