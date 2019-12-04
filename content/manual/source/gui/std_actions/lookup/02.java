@Named("customerField.lookup")
private LookupAction customerFieldLookup;

@Subscribe
public void onInit(InitEvent event) {
    customerFieldLookup.setOpenMode(OpenMode.DIALOG);
    customerFieldLookup.setScreenClass(CustomerBrowse.class);
}
