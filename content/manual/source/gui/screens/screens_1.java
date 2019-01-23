@UiController("sample_FancyMessageScreen")
@UiDescriptor("fancy-message-screen.xml")
public class FancyMessageScreen extends Screen {

    @Inject
    private Label<String> messageLabel;

    public void setFancyMessage(String message) {
        messageLabel.setValue(message);
    }

    @Subscribe("closeBtn")
    protected void onCloseBtnClick(Button.ClickEvent event) {
        close(WINDOW_CLOSE_ACTION);
    }
}