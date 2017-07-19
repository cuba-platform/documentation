@Inject
private Button helloBtn;

@Override
public void init(Map<String, Object>params) {
    helloBtn.setAction(new BaseAction("hello") {
        @Override
        public void actionPerform(Component component) {
            showNotification("Hello!", NotificationType.TRAY);
        }
    });
    // OR
    helloBtn.setAction(new BaseAction("hello")
            .withHandler(e -> showNotification("Hello", NotificationType.TRAY)));
}