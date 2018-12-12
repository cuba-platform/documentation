@Inject
private Label dynamicLabel;

@Subscribe
protected void onInit(InitEvent event) {
    dynamicLabel.setValue("Some value");
}