@Inject
private Accordion accordion;

private boolean tabInitialized;

@Override
public void init(Map<String, Object> params) {
    accordion.addSelectedTabChangeListener(event -> {
        if ("tabCambridge".equals(event.getSelectedTab().getName())) {
            initCambridgeTab();
        }
    });
}

private void initCambridgeTab(){
    if (tabInitialized) {
        return;
    }
    tabInitialized = true;
    // initialization code here
    // use getComponentNN("comp_id") here to get lazy tab's components
}