@Inject
protected OptionDialogFacet optionDialog;
@Inject
protected Notifications notifications;

@Install(to = "optionDialog.ok", subject = "actionHandler") // <1>
protected void onDialogOkAction(DialogActionPerformedEvent<OptionDialogFacet> event) {
    String actionId = event.getDialogAction().getId();

    notifications.create(Notifications.NotificationType.TRAY)
            .withCaption("Dialog action performed: " + actionId)
            .show();
}

@Install(to = "optionDialog.cancel", subject = "actionHandler") // <2>
protected void onDialogCancelAction(DialogActionPerformedEvent<OptionDialogFacet> event) {
    String actionId = event.getDialogAction().getId();

    notifications.create(Notifications.NotificationType.TRAY)
            .withCaption("Dialog action performed: " + actionId)
            .show();
}