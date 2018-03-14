customersTableExcel.setBeforeActionPerformedHandler(() -> {
    showNotification("The selected data will ve downloaded as an XLS file");
    return isValid();
});