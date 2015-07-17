@Inject
private Timer helloTimer;

@Override
public void init(Map<String, Object> params) {
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
}