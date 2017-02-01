textField.addTextChangeListener(event -> {
    int length = event.getText().length();
    textFieldLabel.setValue(length + " of " + textField.getMaxLength());
});
textField.setTextChangeEventMode(TextInputField.TextChangeEventMode.LAZY);