@Order(15)
@EventListener
protected void onUserRemove(UserRemovedEvent event) {
    notifications.create()
            .withCaption("User is removed " + event.getUser())
            .show();
}