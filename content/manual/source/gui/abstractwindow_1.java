private Pattern pattern = Pattern.compile("\\d");

@Override
protected void postValidate(ValidationErrors errors) {
    if (getItem().getAddress().getCity() != null) {
        if (pattern.matcher(getItem().getAddress().getCity()).find()) {
            errors.add("City name can't contain digits");
        }
    }
}