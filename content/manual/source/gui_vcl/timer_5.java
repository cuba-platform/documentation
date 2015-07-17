@Inject
private ComponentsFactory componentsFactory;

@Override
public void init(Map<String, Object> params) {
    Timer helloTimer = componentsFactory.createTimer();
    helloTimer.setDelay(5000);
    helloTimer.setRepeating(true);
    helloTimer.addTimerListener(new Timer.TimerListener() {
        @Override
        public void onTimer(Timer timer) {
            showNotification("Hello", NotificationType.HUMANIZED);
        }

        @Override
        public void onStopTimer(Timer timer) {
            showNotification("Timer is stopped", NotificationType.HUMANIZED);
        }
    });
    helloTimer.start();

    addTimer(helloTimer);
}