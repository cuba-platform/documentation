public class WebCustomerBrowseCompanion implements CustomerBrowse.Companion {
    @Override
    public void initTable(Table<Customer> table) {
        com.vaadin.ui.Table webTable = (com.vaadin.ui.Table) WebComponentsHelper.unwrap(table);
        // do something specific to Vaadin table
    }
}