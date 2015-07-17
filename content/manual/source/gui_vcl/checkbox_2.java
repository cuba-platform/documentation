@Inject
private CheckBox accessField;

@Override
public void init(Map<String, Object> params) {
    accessField.addListener(new ValueListener<Object>() {
        @Override
        public void valueChanged(Object source, String property, Object prevValue, Object value) {
            if (Boolean.TRUE.equals(value)) {
                showNotification("set", NotificationType.HUMANIZED);
            } else {
                showNotification("not set", NotificationType.HUMANIZED);
            }
        }
    });
}