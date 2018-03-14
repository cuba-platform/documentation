customersTableExclude.setBeforeActionPerformedHandler(() -> {
    showNotification("The selected customer will be excluded");
    return isValid();
});