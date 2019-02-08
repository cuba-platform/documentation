import com.haulmont.cuba.gui.screen.ScreenOptions;

public class FancyMessageOptions implements ScreenOptions {

    private String message;

    public FancyMessageOptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}