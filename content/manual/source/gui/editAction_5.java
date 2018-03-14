customersTableEdit.setBeforeActionPerformedHandler(() -> {
    showNotification("The customer instance will be edited");
    return isValid();
});