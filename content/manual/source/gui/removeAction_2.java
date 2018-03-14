customersTableRemove.setBeforeActionPerformedHandler(() -> {
    showNotification("The customer instance will be removed");
    return isValid();
});