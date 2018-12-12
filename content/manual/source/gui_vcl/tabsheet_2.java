@Inject
private TabSheet tabSheet;

private boolean detailsInitialized, historyInitialized;

@Subscribe
protected void onInit(InitEvent event) {
    tabSheet.addSelectedTabChangeListener(selectedTabChangeEvent -> {
        if ("detailsTab".equals(selectedTabChangeEvent.getSelectedTab().getName())) {
            initDetails();
        } else if ("historyTab".equals(selectedTabChangeEvent.getSelectedTab().getName())) {
            initHistory();
        }
    });
}

private void initDetails() {
    if (detailsInitialized) {
        return;
    }
    detailsInitialized = true; <1>
}

private void initHistory() {
    if (historyInitialized) {
        return;
    }
    historyInitialized = true; <2>
}