private Pattern pattern = Pattern.compile("\\d");

@Override
protected void validateAdditionalRules(ValidationErrors errors) {
    if (getEditedEntity().getAddress().getCity() != null) {
        if (pattern.matcher(getEditedEntity().getAddress().getCity()).find()) {
            errors.add("City name cannot contain digits");
        }
    }
    super.validateAdditionalRules(errors);
}