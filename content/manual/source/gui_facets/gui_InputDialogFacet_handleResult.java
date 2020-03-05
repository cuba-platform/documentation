@Install(to = "inputDialogFacet", subject = "dialogResultHandler")
public void handleDialogResults(InputDialog.InputDialogResult dialogResult) {
    String closeActionType = dialogResult.getCloseActionType().name();
    String values = dialogResult.getValues().entrySet()
            .stream()
            .map(entry -> String.format("%s = %s", entry.getKey(), entry.getValue()))
            .collect(Collectors.joining(", "));

    notifications.create(Notifications.NotificationType.HUMANIZED)
            .withCaption("InputDialog Result Handler")
            .withDescription("Close Action: " + closeActionType +
                    ". Values: " + values)
            .show();
}