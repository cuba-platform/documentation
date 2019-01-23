@Inject
private Dialogs dialogs;

@Subscribe("showDialogBtn")
protected void onShowDialogBtnClick(Button.ClickEvent event) {
    dialogs.createOptionDialog()
            .withCaption("Confirm")
            .withMessage("Are you sure?")
            .withActions(
                new DialogAction(DialogAction.Type.YES, Action.Status.PRIMARY).withHandler(e -> {
                    doSomething();
                }),
                new DialogAction(DialogAction.Type.NO)
            )
            .show();
}