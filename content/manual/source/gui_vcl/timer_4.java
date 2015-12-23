@Inject
private Timer helloTimer;

@Override
public void init(Map<String, Object> params) {
    // add execution handler
    helloTimer.addActionListener(timer -> {
        showNotification("Hello", NotificationType.HUMANIZED);
    });
    // add stop listener
    helloTimer.addStopListener(timer -> {
        showNotification("Timer is stopped", NotificationType.HUMANIZED);
    });
    // start the timer
    helloTimer.start();
}