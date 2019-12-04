@Named("customerField.open")
private OpenAction customerFieldOpen;

@Subscribe
public void onInit(InitEvent event) {
    customerFieldOpen.setOpenMode(OpenMode.DIALOG);
    customerFieldOpen.setScreenClass(CustomerEdit.class);
}
