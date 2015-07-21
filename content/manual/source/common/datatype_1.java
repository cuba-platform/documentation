public class GeoCoordinateDatatype extends DoubleDatatype {

    public static final String NAME = "geocoordinate";

    // the format is the same for all locales but may differ in decimal points
    public static final String FORMAT = "#0.000000";

    public GeoCoordinateDatatype(Element element) {
        super(element);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String format(Double value, Locale locale) {
        if (value == null)
            return "";
        FormatStrings formatStrings = Datatypes.getFormatStrings(locale);
        if (formatStrings == null)
            return format(value); // FormatStrings are not defined for locales, so formatting is made according to  datatypes.xml file

        NumberFormat format = new DecimalFormat(FORMAT, formatStrings.getFormatSymbols());
        return format.format(value);
    }

    @Override
    public Double parse(String value, Locale locale) throws ParseException {
        if (StringUtils.isBlank(value))
            return null;
        FormatStrings formatStrings = Datatypes.getFormatStrings(locale);
        if (formatStrings == null)
            return parse(value); // FormatStrings are not defined for locales, so parsing is made according to  datatypes.xml file

        NumberFormat format = new DecimalFormat(FORMAT, formatStrings.getFormatSymbols());
        return parse(value, format).doubleValue();
    }
}