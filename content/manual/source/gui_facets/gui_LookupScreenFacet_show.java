@Inject
protected LookupScreenFacet userLookup;

@Subscribe("showDialog")
public void onShowDialogClick(Button.ClickEvent event) {
    userLookup.show();
}