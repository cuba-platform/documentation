tipsPivotTableUI.addCellClickListener(event -> {
    showNotification("Value: " + event.getValue() + ",\n"
        + "Filters applied: " + event.getFilters());
});