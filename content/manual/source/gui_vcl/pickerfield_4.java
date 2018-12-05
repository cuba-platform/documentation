@Inject
private InstanceContainer<Car> carDc;
@Inject
private UiComponents uiComponents;
@Inject
private Actions actions;

@Subscribe
protected void onInit(InitEvent event) {
    PickerField<Color> colorField = uiComponents.create(PickerField.NAME);
    colorField.setValueSource(new ContainerValueSource<>(carDc, "color"));
    colorField.addAction(actions.create(LookupAction.class));
    colorField.addAction(actions.create(OpenAction.class));
    colorField.addAction(actions.create(ClearAction.class));
    getWindow().add(colorField);
}
