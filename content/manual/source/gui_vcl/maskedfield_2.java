@Inject
private MaskedField phoneNumberField;

public void showPhoneNumber(){
    showNotification((String) phoneNumberField.getValue(), NotificationType.HUMANIZED);
}