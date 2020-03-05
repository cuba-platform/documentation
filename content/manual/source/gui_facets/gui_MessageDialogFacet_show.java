@Inject
protected MessageDialogFacet messageDialog;

@Subscribe("showDialog")
public void onShowDialogClick(Button.ClickEvent event) {
    messageDialog.show();
}