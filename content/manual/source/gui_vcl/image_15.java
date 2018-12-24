image.addClickListener(clickEvent -> {
    if (clickEvent.isDoubleClick())
        notifications.create()
                .withCaption("Double clicked")
                .show();
});