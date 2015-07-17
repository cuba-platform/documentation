public class PositiveIntegerValidator implements Field.Validator {
    @Override
    public void validate(Object value) throws ValidationException {
        Integer i = (Integer) value;
        if (i <= 0)
            throw new ValidationException("Value must be positive");
    }
}