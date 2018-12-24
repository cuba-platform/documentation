@Inject
private Notifications notifications;
@Inject
private Button helloBtn;

@Subscribe
protected void onInit(InitEvent event) {
    helloBtn.setAction(new BaseAction("hello") {
        @Override
        public boolean isPrimary() {
            return true;
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
    helloBtn.setAction(new BaseAction("hello")
            .withPrimary(true)
            .withHandler(e ->
                    notifications.create()
                            .withCaption("Hello!")
                            .withType(Notifications.NotificationType.TRAY)
                            .show()));
}