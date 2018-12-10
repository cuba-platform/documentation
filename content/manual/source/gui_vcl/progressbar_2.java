@Inject
private ProgressBar progressBar;
@Inject
private BackgroundWorker backgroundWorker;

private static final int ITERATIONS = 5;

@Subscribe
protected void onInit(InitEvent event){
    BackgroundTask<Integer, Void> task = new BackgroundTask<Integer, Void>(300, getWindow()) {
        @Override
        public Void run(TaskLifeCycle<Integer> taskLifeCycle) throws Exception{
            for(int i = 1; i <= ITERATIONS; i++) {
                TimeUnit.SECONDS.sleep(2); <1>
                taskLifeCycle.publish(i);
            }
            return null;
        }

        @Override
        public void progress(List<Integer> changes){
            double lastValue = changes.get(changes.size() - 1);
            progressBar.setValue((lastValue / ITERATIONS));
        }
    };

    BackgroundTaskHandler taskHandler = backgroundWorker.handle(task);
    taskHandler.execute();
}

