@UiController("demo_DemoScreen")
@UiDescriptor("demo-screen.xml")
public class DemoScreen extends Screen {
    @Inject
    private ScreenValidation screenValidation;
    @Inject
    private Form demoForm;
	
    @Subscribe("validateBtn")
    public void onValidateBtnClick(Button.ClickEvent event) {
        ValidationErrors errors = screenValidation.validateUiComponents(demoForm);
        if (!errors.isEmpty()) {
            screenValidation.showValidationErrors(this, errors);
            return;
        }
    }
}