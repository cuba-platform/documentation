@Inject
protected UiComponents uiComponents;

@Override
public void init(Map<String, Object> params) {
    PickerField colourField = uiComponents.create(PickerField.NAME);
    colourField.setDatasource(carDs, "colour");
    colourField.addLookupAction();
    colourField.addOpenAction();
    colourField.addClearAction();
}