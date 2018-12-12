@Inject
private Notifications notifications;
@Inject
BrowserFrame browserFrame;

@Subscribe
protected void onInit(InitEvent event) {
    browserFrame.addSourceChangeListener(sourceChangeEvent ->
            notifications.create()
                    .withCaption("Content updated")
                    .show());
}