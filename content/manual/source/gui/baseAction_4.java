@Inject
private Table table;

@Override
public void init(Map<String, Object> params) {
    table.addAction(new ItemTrackingAction("hello") {
        @Override
        public void actionPerform(Component component) {
            showNotification("Hello " + table.getSelected().iterator().next(), NotificationType.TRAY);
        }
    });
}