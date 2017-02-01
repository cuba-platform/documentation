textArea.addTextChangeListener(event -> {
    int length = event.getText().length();
    textAreaLabel.setValue(length + " of " + textArea.getMaxLength());
});