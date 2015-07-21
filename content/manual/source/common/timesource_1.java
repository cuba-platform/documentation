@Inject
protected TimeSource timeSource;
...
Date date = timeSource.currentTimestamp();