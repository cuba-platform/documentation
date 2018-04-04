tipsPivotTableUI.addRefreshListener(event -> {
    showNotification("Row order :" + event.getRowOrder() + ",\n"
        + "Inclusions: " + event.getInclusions());
});