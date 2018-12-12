@Inject
private MaskedField phoneNumberField;
@Inject
private Notifications notifications;

@Subscribe("showPhoneNumberBtn")
protected void onShowPhoneNumberBtnClick(Button.ClickEvent event) {
    notifications.create()
            .withCaption((String) phoneNumberField.getValue())
            .withType(Notifications.NotificationType.HUMANIZED)
            .show();
}