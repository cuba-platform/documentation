@Inject
private Button reportButton;

@Subscribe
public void onInit(InitEvent event) {
    reportButton.setAction(new EditorPrintFormAction(this,null));
}