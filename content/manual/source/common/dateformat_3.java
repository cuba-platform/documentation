@Inject
protected Messages messages;
@Inject
protected UserSessionSource userSessionSource;
...
String coordinateFormat = messages.getMainMessage("coordinateFormat");
FormatStrings formatStrings = Datatypes.getFormatStrings(userSessionSource.getLocale());
NumberFormat format = new DecimalFormat(coordinateFormat, formatStrings.getFormatSymbols());

String formattedValue = format.format(value);