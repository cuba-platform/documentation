@Inject
private BoxLayout container;

@Override
public void init(Map&lt;String, Object&gt; params) {
    SomeFrame frame = openFrame(container, "someFrame");
    frame.setHeight("100%");
    frame.someInitMethod();
}