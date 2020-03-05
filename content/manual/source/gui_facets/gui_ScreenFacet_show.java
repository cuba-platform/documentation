@Inject
protected ScreenFacet testScreen;

@Subscribe("showDialog")
public void onShowDialogClick(Button.ClickEvent event) {
    testScreen.show();
}