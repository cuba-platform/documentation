@Named("carsTable.create")
private CreateAction createAction;

@Named("carsTable.copy")
private Action copyAction;

@Inject
private PickerField colourField;

@Override
public void init(Map<String, Object> params) {
    Map<String, Object> values = new HashMap<>();
    values.put("type", CarType.PASSENGER);
    createAction.setInitialValues(values);

    copyAction.setEnabled(false);

    Action showAction = colourField.getAction("show");
    showAction.setEnabled(false);
}