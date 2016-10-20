@Inject
private Accordion accordion;

private boolean tabInitialized;

@Override
public void init(Map<String, Object> params) {
    accordion.addListener(new Accordion.TabChangeListener() {
        @Override
        public void tabChanged(Accordion.Tab newTab) {
            if ("tabCambridge".equals(newTab.getName())) {
                initCambridgeTab();
            }
        }
    });
}

private void initCambridgeTab() {
    if (tabInitialized) {
        return;
    }
    tabInitialized = true;
    // initialization code here
}