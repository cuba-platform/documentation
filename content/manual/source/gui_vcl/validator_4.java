zipField.addValidator(value -> {
    if (value != null && value.length() != 6)
        throw new ValidationException("Zip must be of 6 characters length");
});