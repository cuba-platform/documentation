@Inject
protected PickerField colourField;

@Subscribe
protected void onInit(InitEvent event) {
    colourField.addAction(actions.create(OpenAction.class));
}