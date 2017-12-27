import com.haulmont.cuba.gui.icons.Icons;

public enum IcoMoonIcon implements Icons.Icon {
    HEADPHONES("ico-moon:HEADPHONES"),
    SPINNER("ico-moon:SPINNER");

    protected String source;

    IcoMoonIcon(String source) {
        this.source = source;
    }

    @Override
    public String source() {
        return source;
    }
}