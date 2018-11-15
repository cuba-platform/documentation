@Inject
private UiComponents uiComponents;

@Inject
private BoxLayout box;

@Override
public void init(Map<String, Object>params) {
    PickerField pickerField = uiComponents.create(PickerField.NAME);

    pickerField.addAction(new BaseAction("hello") {
        @Override
        public String getCaption() {
            return null;
        }

        @Override
        public String getDescription() {
            return getMessage("helloDescription");
        }

        @Override
        public String getIcon() {
            return"icons/hello.png";
        }

        @Override
        public void actionPerform(Component component) {
            showNotification("Hello!", NotificationType.TRAY);
        }
    });
    // OR
    pickerField.addAction(new BaseAction("hello")
            .withCaption(null)
            .withDescription(getMessage("helloDescription"))
            .withIcon("icons/ok.png")
            .withHandler(e -> showNotification("Hello", NotificationType.TRAY)));

    box.add(pickerField);
}