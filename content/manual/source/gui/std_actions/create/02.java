@Named("customersTable.create")
private CreateAction customersTableCreate;

@Subscribe
public void onInit(InitEvent event) {
    customersTableCreate.setOpenMode(OpenMode.DIALOG);
    customersTableCreate.setScreenClass(CustomerEdit.class);
}
