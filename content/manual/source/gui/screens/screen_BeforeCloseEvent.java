@Subscribe
protected void onBeforeClose(BeforeCloseEvent event) {
    if (Strings.isNullOrEmpty(textField.getValue())) {
        notifications.create().withCaption("Input required").show();
        event.preventWindowClose();
    }
}
