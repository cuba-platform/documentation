customersTableAdd.setBeforeActionPerformedHandler(() -> {
    notifications.create()
            .withCaption("The new customer will be added")
            .show();
    return isValid();
});