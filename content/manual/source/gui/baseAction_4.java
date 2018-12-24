@Inject
private Table table;
@Inject
private Notifications notifications;

@Subscribe
protected void onInit(InitEvent event) {
    table.addAction(new ItemTrackingAction("hello") {
        @Override
        public void actionPerform(Component component) {
            notifications.create()
                    .withCaption("Hello " + table.getSelected().iterator().next())
                    .withType(Notifications.NotificationType.TRAY)
                    .show();
        }
    });
}