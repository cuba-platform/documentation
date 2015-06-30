public class ZipValidator implements Field.Validator {
    @Override
    public void validate(Object value) throws ValidationException {
        if (value != null && ((String) value).length() != 6)
            throw new ValidationException("Zip must be of 6 characters length");
    }
}