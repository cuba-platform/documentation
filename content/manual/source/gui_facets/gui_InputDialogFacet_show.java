@Inject
protected InputDialogFacet inputDialog;

@Subscribe("showDialog")
public void onShowDialogClick(Button.ClickEvent event) {
    inputDialog.show();
}