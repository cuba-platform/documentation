@Inject
private Dialogs dialogs;

@Subscribe("showDialogBtn")
protected void onShowDialogBtnClick(Button.ClickEvent event) {
    dialogs.createMessageDialog()
            .withCaption("Information")
            .withMessage("<i>Message<i/>")
            .withContentMode(ContentMode.HTML)
            .withCloseOnClickOutside(true)
            .withWidth("100px")
            .withHeight("300px")
            .show();
}
