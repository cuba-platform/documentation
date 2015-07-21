@Inject
private BoxLayout box;
@Inject
private ComponentsFactory componentsFactory;

@Override
public void init(Map<String, Object> params) {
    MyComponent myComponent = componentsFactory.createComponent(MyComponent.NAME);
    box.addComponent(myComponent);
    ...
}