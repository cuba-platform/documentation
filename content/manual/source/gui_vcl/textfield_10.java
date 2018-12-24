textField.addEnterPressListener(enterPressEvent ->
        notifications.create()
                .withCaption("Enter pressed")
                .show());