@Inject
private UiComponents uiComponents;
@Inject
private Notifications notifications;
@Inject
private MessageBundle messageBundle;
@Inject
private HBoxLayout box;

@Subscribe
protected void onInit(InitEvent event) {
    PickerField pickerField = uiComponents.create(PickerField.NAME);

    pickerField.addAction(new BaseAction("hello") {
        @Override
        public String getCaption() {
            return null;
        }

        @Override
        public String getDescription() {
            return messageBundle.getMessage("helloDescription");
        }

        @Override
        public String getIcon() {
            return "icons/hello.png";
        }

        @Override
        public void actionPerform(Component component) {
            notifications.create()
                    .withCaption("Hello!")
                    .withType(Notifications.NotificationType.TRAY)
                    .show();
        }
    });
    // OR
    pickerField.addAction(new BaseAction("hello")
            .withCaption(null)
            .withDescription(messageBundle.getMessage("helloDescription"))
            .withIcon("icons/ok.png")
            .withHandler(e ->
                    notifications.create()
                            .withCaption("Hello!")
                            .withType(Notifications.NotificationType.TRAY)
                            .show()));
    box.add(pickerField);
}