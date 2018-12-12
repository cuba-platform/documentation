@Inject
private Accordion accordion;

private boolean tabInitialized;

@Subscribe
protected void onInit(InitEvent event) {
    accordion.addSelectedTabChangeListener(selectedTabChangeEvent -> {
        if ("tabCambridge".equals(selectedTabChangeEvent.getSelectedTab().getName())) {
            initCambridgeTab();
        }
    });
}

private void initCambridgeTab() {
    if (tabInitialized) {
        return;
    }
    tabInitialized = true;
    <1>
}