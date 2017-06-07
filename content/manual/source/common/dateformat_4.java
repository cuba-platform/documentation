@Inject
private DateField dateField;
...
DatatypeFormatter formatter = AppBeans.get(DatatypeFormatter.class);
String localDate = formatter.formatDate(dateField.getValue());