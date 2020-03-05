@Inject
protected OptionDialogFacet optionDialog;

@Subscribe("showDialog")
public void onShowDialogClick(Button.ClickEvent event) {
    optionDialog.show();
}