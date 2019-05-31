@Inject
private Timer helloTimer;
@Inject
private Notifications notifications;

@Subscribe("helloTimer")
protected void onHelloTimerTimerAction(Timer.TimerActionEvent event) { <1>
    notifications.create()
            .withCaption("Hello")
            .show();
}

@Subscribe("helloTimer")
protected void onHelloTimerTimerStop(Timer.TimerStopEvent event) { <2>
    notifications.create()
            .withCaption("Timer is stopped")
            .show();
}

@Subscribe
protected void onInit(InitEvent event) { <3>
    helloTimer.start();
}
