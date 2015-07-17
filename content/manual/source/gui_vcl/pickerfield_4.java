@Inject
protected ComponentsFactory componentsFactory;

@Override
public void init(Map<String, Object> params) {
    PickerField colourField = componentsFactory.createComponent(PickerField.NAME);
    colourField.setDatasource(carDs, "colour");
    colourField.addLookupAction();
    colourField.addOpenAction();
    colourField.addClearAction();
}