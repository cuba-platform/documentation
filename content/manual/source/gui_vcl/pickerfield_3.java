@Inject
protected PickerField<Color> colorField;

@Subscribe
protected void onInit(InitEvent event) {
    colorField.addAction(actions.create(OpenAction.class));
}