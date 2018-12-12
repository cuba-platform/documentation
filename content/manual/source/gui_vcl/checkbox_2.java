@Inject
private CheckBox accessField;
@Inject
private Notifications notifications;

@Subscribe
protected void onInit(InitEvent event) {
    accessField.addValueChangeListener(valueChangeEvent -> {
        if (Boolean.TRUE.equals(valueChangeEvent.getValue())) {
            notifications.create()
                    .withCaption("set")
                    .show();
        } else {
            notifications.create()
                    .withCaption("not set")
                    .show();
        }
    });
}