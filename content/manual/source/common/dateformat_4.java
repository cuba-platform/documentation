@Inject
private DatatypeFormatter formatter;
...
String localDate = formatter.formatDate(dateField.getValue());