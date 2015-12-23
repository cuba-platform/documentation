@Inject
private ComponentsFactory componentsFactory;

@Override
public void init(Map<String, Object> params) {
    // create timer
    Timer helloTimer = componentsFactory.createTimer();
    // add timer to the screen
    addTimer(helloTimer);
    // set timer parameters
    helloTimer.setDelay(5000);
    helloTimer.setRepeating(true);
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