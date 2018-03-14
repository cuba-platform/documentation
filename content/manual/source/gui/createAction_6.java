customersTableCreate.setBeforeActionPerformedHandler(() -> {
    showNotification("The new customer instance will be created");
    return isValid();
});