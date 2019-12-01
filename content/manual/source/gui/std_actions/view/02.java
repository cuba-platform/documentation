@Named("customersTable.view")
private ViewAction customersTableView;

@Subscribe
public void onInit(InitEvent event) {
    customersTableView.setOpenMode(OpenMode.DIALOG);
    customersTableView.setScreenClass(CustomerEdit.class);
}
