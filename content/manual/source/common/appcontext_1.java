AppContext.addListener(new AppContext.Listener() {
    @Override
    public void applicationStarted() {
        System.out.println("Application is ready");
    }

    @Override
    public void applicationStopped() {
        System.out.println("Application is closing");
    }
});