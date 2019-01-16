@Inject
private Dialogs dialogs;

@Subscribe("showDialogBtn")
protected void onShowDialogBtnClick(Button.ClickEvent event) {
    dialogs.createMessageDialog().withCaption("Information").withMessage("Message").show();
}
