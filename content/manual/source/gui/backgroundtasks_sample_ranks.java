
@UiController("playground_RankMonitor")
@UiDescriptor("rank-monitor.xml")
public class RankMonitor extends Screen {
    @Inject
    private Notifications notifications;
    @Inject
    private Label<String> refreshTimeLabel;
    @Inject
    private CollectionContainer<Rank> ranksDc;
    @Inject
    private RankService rankService;
    @Inject
    private CheckBox onlyActiveBox;
    @Inject
    private Logger log;
    @Inject
    private TimeSource timeSource;
    @Inject
    private Timer refreshTimer;

    private BackgroundTaskWrapper<Void, List<Rank>> refreshTaskWrapper = new BackgroundTaskWrapper<>(); // <1>

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        refreshTimer.setDelay(5000);
        refreshTimer.setRepeating(true);
        refreshTimer.start();
    }

    @Subscribe("onlyActiveBox")
    public void onOnlyActiveBoxValueChange(HasValue.ValueChangeEvent<Boolean> event) {
        refreshTaskWrapper.restart(new RefreshScreenTask()); // <2>
    }

    @Subscribe("refreshTimer")
    public void onRefreshTimerTimerAction(Timer.TimerActionEvent event) {
        refreshTaskWrapper.restart(new RefreshScreenTask()); // <3>
    }

    public class RefreshScreenTask extends BackgroundTask<Void, List<Rank>> { // <4>
        private boolean onlyActive; // <5>
        protected RefreshScreenTask() {
            super(30, TimeUnit.SECONDS, RankMonitor.this);
            onlyActive = onlyActiveBox.getValue();
        }

        @Override
        public List<Rank> run(TaskLifeCycle<Void> taskLifeCycle) throws Exception {
            List<Rank> data = rankService.loadActiveRanks(onlyActive); // <6>
            return data;
        }

        @Override
        public void done(List<Rank> result) { // <7>
            List<Rank> mutableItems = ranksDc.getMutableItems();
            mutableItems.clear();
            mutableItems.addAll(result);

            String hhmmss = new SimpleDateFormat("HH:mm:ss").format(timeSource.currentTimestamp());
            refreshTimeLabel.setValue("Last time refreshed: " + hhmmss);
        }

        @Override
        public boolean handleTimeoutException() { // <8>
            displayRefreshProblem();
            return true;
        }

        @Override
        public boolean handleException(Exception ex) { // <9>
            log.debug("Auto-refresh error", ex);
            displayRefreshProblem();
            return true;
        }

        private void displayRefreshProblem() {
            if (!refreshTimeLabel.getValue().endsWith("(outdated)")) {
                refreshTimeLabel.setValue(refreshTimeLabel.getValue() + " (outdated)");
            }
            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption("Problem refreshing data")
                    .withHideDelayMs(10_000)
                    .show();
        }
    }
}