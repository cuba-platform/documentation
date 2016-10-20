@Inject
private Accordion accordion;
private Accordion.Tab tabBoston;
private Accordion.Tab tabLondon;

private boolean detailsInitialized;

@Override
public void init(Map<String, Object> params){
        tabBoston=accordion.getTab("tabBoston");
        tabLondon=accordion.getTab("tabLondon");
        accordion.addListener(new Accordion.TabChangeListener(){
@Override
public void tabChanged(Accordion.Tab newTab){
        if("tabCambridge".equals(newTab.getName())){
        initDetails();
        }
        }
        });
        }

private void initDetails(){
        if(detailsInitialized){
        return;
        }
        detailsInitialized=true;
        }