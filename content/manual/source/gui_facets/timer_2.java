@Inject
private Notifications notifications;

@Subscribe("myTimer")
private void onTimer(Timer.TimerActionEvent event) {
    notifications.create(Notifications.NotificationType.TRAY)
        .withCaption("on timer")
        .show();
}