public Object build(String string) {
    if (string == null) {
        return null;
    }
    return UUID.fromString(string);
}