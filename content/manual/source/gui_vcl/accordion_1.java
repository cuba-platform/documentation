@Inject
private Accordion accordion;
private boolean detailsInitialized;

@Override
public void init(Map<String, Object> params){
    Accordion.Tab tabBoston = accordion.getTab("tabBoston");
    Accordion.Tab tabLondon = accordion.getTab("tabLondon");
    accordion.addListener(new Accordion.TabChangeListener(){
        @Override
        public void tabChanged(Accordion.Tab newTab){
            if ("tabCambridge".equals(newTab.getName())){
                initDetails();
            }
        }
    });
}

private void initDetails(){
    if (detailsInitialized){
        return;
    }
    detailsInitialized=true;
}