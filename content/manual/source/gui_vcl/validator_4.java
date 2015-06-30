if (Boolean.TRUE.equals(parameter.getRequired())) {
    tokenList.addValidator(new Field.Validator() {
        @Override
        public void validate(Object value) throws ValidationException {
            if (value instanceof Collection && CollectionUtils.isEmpty((Collection) value)) {
                throw new ValidationException(getMessage("paramIsRequiredButEmpty"));
            }
        }
    });
}