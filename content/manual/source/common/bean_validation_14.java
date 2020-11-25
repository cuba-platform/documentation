public class EventEdit extends StandardEditor<Event> {
    @Subscribe
    public void onInit(InitEvent event) {
        setCrossFieldValidate(false);
    }
}