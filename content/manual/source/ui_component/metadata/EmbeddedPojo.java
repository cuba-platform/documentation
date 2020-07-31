public class FormattingOptions {
    private String textColor = "black";
    private boolean foldComments = true;

    @StudioProperty(defaultValue = "black", description = "Main text color")
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    @StudioProperty(defaultValue = "true")
    public void setFoldComments(boolean foldComments) {
        this.foldComments = foldComments;
    }
}
