public class CustomerEdit extends StandardEditor<Customer> {
    @Inject
    private LookupScreens lookupScreens;
    @Inject
    private Table<Employee> accountableTable;

    @Subscribe("accountableTable.add")
    protected void onAccountableTableAddActionPerformed(Action.ActionPerformedEvent event) {
        lookupScreens.builder(Employee.class, this)
                .withListComponent(accountableTable)
                .withScreen(EmployeeBrowse.class)       // specific editor screen
                .withLaunchMode(OpenMode.DIALOG)        // open as modal dialog
                .build()
                .show();
    }
