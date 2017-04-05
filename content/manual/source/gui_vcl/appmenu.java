public class ExtAppMainWindow extends AppMainWindow {

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        AppMenu.MenuItem item = mainMenu.createMenuItem("shop", "Shop");
        AppMenu.MenuItem subItem = mainMenu.createMenuItem("customer", "Customers", null, menuItem -> {
            showNotification("Customers menu item clicked", NotificationType.HUMANIZED);
        });
        item.addChildItem(subItem);
        mainMenu.addMenuItem(item, 0);
    }
}