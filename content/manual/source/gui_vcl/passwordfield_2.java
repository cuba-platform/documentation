@Inject
private PasswordField passwordField;
@Inject
private Notifications notifications;

@Subscribe("showPasswordBtn")
protected void onShowPasswordBtnClick(Button.ClickEvent event) {
    notifications.create()
            .withCaption(passwordField.getValue())
            .show();
}