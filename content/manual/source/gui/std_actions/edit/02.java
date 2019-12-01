@Named("customersTable.edit")
private EditAction customersTableEdit;

@Subscribe
public void onInit(InitEvent event) {
    customersTableEdit.setOpenMode(OpenMode.DIALOG);
    customersTableEdit.setScreenClass(CustomerEdit.class);
}
