package com.company.sample;

import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.datatypes.FormatStrings;
import com.haulmont.chile.core.datatypes.impl.DoubleDatatype;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class GeoCoordinateDatatype extends DoubleDatatype {

    // This field is required for Studio even if you don't use it in code
    public static final String NAME = "geocoordinate";

    // The format is the same for all locales but may differ in decimal points
    public static final String FORMAT = "#0.000000";

    public GeoCoordinateDatatype(Element element) {
        super(element);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String format(Object value, Locale locale) {
        if (value == null)
            return "";
        FormatStrings formatStrings = Datatypes.getFormatStrings(locale);
        if (formatStrings == null)
            return format(value);

        NumberFormat format = new DecimalFormat(FORMAT, formatStrings.getFormatSymbols());
        return format.format(value);
    }

    @Override
    public Double parse(String value, Locale locale) throws ParseException {
        if (StringUtils.isBlank(value))
            return null;
        FormatStrings formatStrings = Datatypes.getFormatStrings(locale);
        if (formatStrings == null)
            return parse(value);

        NumberFormat format = new DecimalFormat(FORMAT, formatStrings.getFormatSymbols());
        return parse(value, format).doubleValue();
    }
}