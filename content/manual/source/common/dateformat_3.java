@Inject
protected Messages messages;
@Inject
protected UserSessionSource userSessionSource;
@Inject
protected FormatStringsRegistry formatStringsRegistry;

void sample() {
    String coordinateFormat = messages.getMainMessage("coordinateFormat");
    FormatStrings formatStrings = formatStringsRegistry.getFormatStrings(userSessionSource.getLocale());
    NumberFormat format = new DecimalFormat(coordinateFormat, formatStrings.getFormatSymbols());
    String formattedValue = format.format(value);
    // ...
}