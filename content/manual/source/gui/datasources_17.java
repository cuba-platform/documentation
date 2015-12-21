employeesDs.addStateChangeListener(event -> {
    if (event.getState() == Datasource.State.VALID)
        initDataTypeColumn();
});