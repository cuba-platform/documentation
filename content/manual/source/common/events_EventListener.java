@Order(15)
@EventListener
protected void onUserRemove(UserRemovedEvent event) {
    showNotification("User is removed " + event.getSource());
}