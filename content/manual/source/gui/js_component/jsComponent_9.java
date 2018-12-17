@UiController("demo_Sandbox")
@UiDescriptor("sandbox.xml")
public class Sandbox extends Screen {
    @Inject
    private JavaScriptComponent quill;

    @Inject
    private Notifications notifications;

    @Subscribe
    protected void onInit(InitEvent event) {
        QuillState state = new QuillState();
        state.options = ParamsMap.of("theme", "snow",
                "placeholder", "Compose an epic...");

        quill.setState(state);

        quill.addFunction("valueChanged", javaScriptCallbackEvent -> {
            String value = javaScriptCallbackEvent.getArguments().getString(0);
            notifications.create()
                    .withCaption(value)
                    .withPosition(Notifications.Position.BOTTOM_RIGHT)
                    .show();
        });
    }

    class QuillState {
        public Map<String, Object> options;
    }
}