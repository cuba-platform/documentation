@Inject
private TabSheet tabsheet;

private boolean detailsInitialized, historyInitialized;

@Override
public void init(Map<String, Object> params) {
    tabsheet.addListener(
        new TabSheet.TabChangeListener() {
            @Override
            public void tabChanged(TabSheet.Tab newTab) {
                if ("detailsTab".equals(newTab.getName())){
                    initDetails();
                } else if ("historyTab".equals(newTab.getName())){
                    initHistory();
                }
            }
        }
    );
}

private void initDetails() {
    if (detailsInitialized){
        return;
    }
    // use getComponentNN("comp_id") here to get tab's components
    detailsInitialized = true;
}

private void initHistory() {
    if (historyInitialized){
        return;
    }
    // use getComponentNN("comp_id") here to get tab's components
    historyInitialized = true;
}