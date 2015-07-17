@Inject
private PasswordField passwordField;

public void showPassword(){
    showNotification((String) passwordField.getValue(), NotificationType.HUMANIZED);
}