@Named("customersTable.add")
private AddAction customersTableAdd;

@Subscribe
public void onInit(InitEvent event) {
    customersTableAdd.setOpenMode(OpenMode.DIALOG);
    customersTableAdd.setScreenClass(CustomerBrowse.class);
}