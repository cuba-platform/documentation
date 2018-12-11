@Inject
private GroupTable<Car> carsTable;
@Inject
private CollectionContainer<Car> carsDc;
@Inject
private CollectionContainer<Color> colorsDc;
@Inject
private UiComponents uiComponents;
@Inject
private Actions actions;

@Subscribe
protected void onInit(InitEvent event) {
    carsTable.addGeneratedColumn("color", entity -> {
        LookupPickerField<Color> field = uiComponents.create(LookupPickerField.NAME);
        field.setValueSource(new ContainerValueSource<>(carsDc, "color"));
        field.setOptions(new ContainerOptions<>(colorsDc));
        field.addAction(actions.create(LookupAction.class));
        field.addAction(actions.create(OpenAction.class));
        return field;
    });
}