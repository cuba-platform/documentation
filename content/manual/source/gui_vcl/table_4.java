@Inject
private Notifications notifications;

public void linkedMethod(Entity item, String columnId) {
    Customer customer = (Customer) item;
    notifications.create()
            .withCaption(customer.getName())
            .show();
}