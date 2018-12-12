public class ExtAppMainWindow extends AppMainWindow {

    @Inject
    private Notifications notifications;

    @Subscribe
    protected void onInit(InitEvent event) {
        AppMenu.MenuItem item = mainMenu.createMenuItem("shop", "Shop");
        AppMenu.MenuItem subItem = mainMenu.createMenuItem("customer", "Customers", null, menuItem -> {
            notifications.create()
                    .withCaption("Customers menu item clicked")
                    .withType(Notifications.NotificationType.HUMANIZED)
                    .show();
        });
        item.addChildItem(subItem);
        mainMenu.addMenuItem(item, 0);
    }
}