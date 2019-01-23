@Inject
private Notifications notifications;
@Inject
private Table<Customer> table;
@Inject
private Security security;

@Subscribe
protected void onInit(InitEvent event) {
    table.addAction(new HelloAction());
}

private class HelloAction extends BaseAction {

    public HelloAction() {
        super("hello");
    }

    @Override
    public void actionPerform(Component component) {
        notifications.create()
                .withCaption("Hello " + table.getSingleSelected())
                .withType(Notifications.NotificationType.TRAY)
                .show();
    }

    @Override
    protected boolean isPermitted() {
        return security.isSpecificPermitted("myapp.allow-greeting");
    }

    @Override
    public boolean isApplicable() {
        return table != null && table.getSelected().size() == 1;
    }
}