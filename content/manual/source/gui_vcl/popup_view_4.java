@Inject
private PopupView popupView;

@Override
public void init(Map<String, Object> params) {
    popupView.addPopupVisibilityListener(event ->
        showNotification(event.isPopupVisible() ? "The popup is visible" : "The popup is hidden",
            NotificationType.HUMANIZED));
}