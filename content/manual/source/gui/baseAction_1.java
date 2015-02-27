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
}