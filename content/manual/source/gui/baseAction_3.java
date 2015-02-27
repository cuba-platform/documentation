@Inject
private Table table;

@Inject
private Security security;

@Override
public void init(Map<String, Object> params) {
    table.addAction(new HelloAction());
}

private class HelloAction extends BaseAction {

    public HelloAction() {
        super("hello");
    }

    @Override
    public void actionPerform(Component component) {
        showNotification("Hello " + table.getSingleSelected(), NotificationType.TRAY);
    }

    @Override
    protected boolean isPermitted() {
        return security.isSpecificPermitted("myapp.allow-greeting");
    }

    @Override
    public boolean isApplicable() {
        return getTargetSelection().size() == 1;
    }
}