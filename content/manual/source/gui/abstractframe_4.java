@Inject
private BoxLayout container;

@Override
public void init(Map<String, Object> params) {
    SomeFrame frame = openFrame(null, "someFrame");
    frame.setHeight("100%");
    frame.someInitMethod();
    container.add(frame);
}