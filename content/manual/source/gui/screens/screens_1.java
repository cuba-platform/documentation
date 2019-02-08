@UiController("demo_FancyMessageScreen")
@UiDescriptor("fancy-message-screen.xml")
@DialogMode(forceDialog = true, width = "300px")
public class FancyMessageScreen extends Screen {

    @Inject
    private Label<String> messageLabel;

    public void setFancyMessage(String message) { // <1>
        messageLabel.setValue(message);
    }

    @Subscribe("closeBtn")
    protected void onCloseBtnClick(Button.ClickEvent event) {
        closeWithDefaultAction();
    }
}