@Inject
private Label dynamicLabel;

public void init(Map<String, Object> params) {
    dynamicLabel.setValue("Some value");
}