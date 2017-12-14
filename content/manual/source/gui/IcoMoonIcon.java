import com.haulmont.cuba.gui.icons.Icons;

public enum IcoMoonIcon implements Icons.Icon {
    HEADPHONES("ico-moon:HEADPHONES"),
    SPINNER("ico-moon:SPINNER");

    protected String id;

    IcoMoonIcon(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return id;
    }
}