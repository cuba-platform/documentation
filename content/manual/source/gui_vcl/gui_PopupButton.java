popupButton.addPopupVisibilityListener(popupVisibilityEvent ->
        notifications.create()
                .withCaption("Popup visibility changed")
                .show());