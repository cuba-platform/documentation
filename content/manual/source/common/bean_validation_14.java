public class TaskEdit extends StandardEditor<Task> {
    @Subscribe
    protected void onInit(InitEvent event) {
        setCrossFieldValidate(false);
    }
}