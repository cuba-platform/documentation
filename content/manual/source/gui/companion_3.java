public class DesktopCustomerBrowseCompanion implements CustomerBrowse.Companion {
    @Override
    public void initTable(Table<Customer> table) {
        javax.swing.JTable desktopTable = (javax.swing.JTable) DesktopComponentsHelper.unwrap(table);
        // do something specific to Swing table
    }
}