@Inject
private PopupView popupView;
@Inject
private Notifications notifications;

@Subscribe
protected void onInit(InitEvent event) {
    popupView.addPopupVisibilityListener(popupVisibilityEvent ->
            notifications.create()
                    .withCaption(popupVisibilityEvent.isPopupVisible() ? "The popup is visible" : "The popup is hidden")
                    .withType(Notifications.NotificationType.HUMANIZED)
                    .show()
    );
}
