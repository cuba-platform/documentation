public class CustomerEdit extends StandardEditor<Customer> {
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Table<Employee> accountableTable;

    @Subscribe("accountableTable.add")
    protected void onAccountableTableAddActionPerformed(Action.ActionPerformedEvent event) {
        screenBuilders.lookup(Employee.class, this)
                .withListComponent(accountableTable)
                .withScreenClass(EmployeeBrowse.class)   // specific editor screen
                .withLaunchMode(OpenMode.DIALOG)        // open as modal dialog
                .build()
                .show();
    }
}
