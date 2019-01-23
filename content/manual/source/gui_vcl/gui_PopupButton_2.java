@Subscribe("popupButton")
protected void onPopupButtonPopupVisibility(PopupButton.PopupVisibilityEvent event) {
    notifications.create()
            .withCaption("Popup visibility changed")
            .show();
}