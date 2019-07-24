public class ZipValidator implements Consumer<String> {
    @Override
    public void accept(String s) throws ValidationException {
        if (s != null && s.length() != 6)
            throw new ValidationException("Zip must be of 6 characters length");
    }
}