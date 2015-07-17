@Inject
protected ProgressBar progressBar;

@Inject
protected BackgroundWorker backgroundWorker;

private static final int ITERATIONS = 5;

@Override
public void init(Map<String, Object> params) {
    BackgroundTask<Integer, Void> task = new BackgroundTask<Integer, Void>(300, this) {
        @Override
        public Void run(TaskLifeCycle<Integer> taskLifeCycle) throws Exception {
            for (int i = 1; i <= ITERATIONS; i++) {
                TimeUnit.SECONDS.sleep(2); // time consuming task
                taskLifeCycle.publish(i);
            }
            return null;
        }

        @Override
        public void progress(List<Integer> changes) {
            float lastValue = changes.get(changes.size() - 1);
            progressBar.setValue(lastValue / ITERATIONS);
        }
    };

    BackgroundTaskHandler taskHandler = backgroundWorker.handle(task);
    taskHandler.execute();
}