import com.vaadin.server.FontIcon;
import com.vaadin.server.GenericFontIcon;

public enum IcoMoon implements FontIcon {

    HEADPHONES(0XE900),
    SPINNER(0XE905);

    public static final String FONT_FAMILY = "IcoMoon";
    private int codepoint;

    IcoMoon(int codepoint) {
        this.codepoint = codepoint;
    }

    @Override
    public String getFontFamily() {
        return FONT_FAMILY;
    }

    @Override
    public int getCodepoint() {
        return codepoint;
    }

    @Override
    public String getHtml() {
        return GenericFontIcon.getHtml(FONT_FAMILY, codepoint);
    }

    @Override
    public String getMIMEType() {
        throw new UnsupportedOperationException(FontIcon.class.getSimpleName()
                + " should not be used where a MIME type is needed.");
    }

    public static IcoMoon fromCodepoint(final int codepoint) {
        for (IcoMoon f : values()) {
            if (f.getCodepoint() == codepoint) {
                return f;
            }
        }
        throw new IllegalArgumentException("Codepoint " + codepoint
                + " not found in IcoMoon");
    }
}
