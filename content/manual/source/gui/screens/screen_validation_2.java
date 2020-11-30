@UiController("demo_DemoScreen")
@UiDescriptor("demo-screen.xml")
public class DemoScreen extends Screen {

    @Inject
    protected Metadata metadata;
    @Inject
    protected ScreenValidation screenValidation;
    @Inject
    protected TimeSource timeSource;

    @Subscribe("validateBtn")
    public void onValidateBtnClick(Button.ClickEvent event) {
        Event event = metadata.create(Event.class);
        event.setName("Demo event");
        event.setStartDate(timeSource.currentTimestamp());

        // We make the endDate earlier than the startDate
        event.setEndDate(DateUtils.addDays(event.getStartDate(), -1));

        ValidationErrors errors = screenValidation.validateCrossFieldRules(this, event);
        if (!errors.isEmpty()) {
            screenValidation.showValidationErrors(this, errors);
        }
    }
}