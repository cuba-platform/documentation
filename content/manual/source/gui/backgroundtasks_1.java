@Inject
protected BackgroundWorker backgroundWorker;

@Override
public void init(Map<String, Object> params) {
    // Create task with 10 sec timeout and this screen as owner
    BackgroundTask<Integer, Void> task = new BackgroundTask<Integer, Void>(10, this) {
        @Override
        public Void run(TaskLifeCycle<Integer> taskLifeCycle) throws Exception {
            // Do something in background thread
            for (int i = 0; i < 5; i++) {
                TimeUnit.SECONDS.sleep(1); // time consuming computations
                taskLifeCycle.publish(i);  // publish current progress to show it in progress() method
            }
            return null;
        }

        @Override
        public void canceled() {
            // Do something in UI thread if the task is canceled
        }

        @Override
        public void done(Void result) {
            // Do something in UI thread when the task is done
        }

        @Override
        public void progress(List<Integer> changes) {
            // Show current progress in UI thread
        }
    };
    // Get task handler object and run the task
    BackgroundTaskHandler taskHandler = backgroundWorker.handle(task);
    taskHandler.execute();
}