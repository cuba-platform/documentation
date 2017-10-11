@Inject
private DatatypeFormatter formatter;

void sample() {
    String dateStr = formatter.formatDate(dateField.getValue());
    // ...
}
