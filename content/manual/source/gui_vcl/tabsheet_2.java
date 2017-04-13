@Inject
private TabSheet tabsheet;

private boolean detailsInitialized, historyInitialized;

@Override
public void init(Map<String, Object> params) {
    tabsheet.addSelectedTabChangeListener(event -> {
        if ("detailsTab".equals(event.getSelectedTab().getName())) {
            initDetails();
        } else if ("historyTab".equals(event.getSelectedTab().getName())) {
            initHistory();
        }
    });
}

private void initDetails(){
    if (detailsInitialized) {
        return;
    }
    // use getComponentNN("comp_id") here to get tab's components
    detailsInitialized=true;
}

private void initHistory(){
    if (historyInitialized) {
        return;
    }
    // use getComponentNN("comp_id") here to get tab's components
    historyInitialized = true;
}