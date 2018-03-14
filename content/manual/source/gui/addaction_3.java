customersTableAdd.setBeforeActionPerformedHandler(() -> {
    showNotification("The new customer will be added");
    return isValid();
});