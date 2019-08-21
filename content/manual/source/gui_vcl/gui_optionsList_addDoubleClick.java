optionsList.addDoubleClickListener(doubleClickEvent ->
        notifications.create()
        .withCaption("Double clicked")
        .show());