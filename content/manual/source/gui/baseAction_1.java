@Inject
private Button helloBtn;

@Override
public void init(Map<String, Object> params) {
    helloBtn.setAction(new BaseAction("hello") {
        @Override
        public boolean isPrimary() {
            return true;
        }

        @Override
        public void actionPerform(Component component) {
            showNotification("Hello!", NotificationType.TRAY);
        }
    });
    // OR
    helloBtn.setAction(new BaseAction("hello")
            .withPrimary(true)
            .withHandler(e -> showNotification("Hello", NotificationType.TRAY)));
}