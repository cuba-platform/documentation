@Inject
protected PickerField colourField;

@Override
public void init(Map<String, Object> params) {
    colourField.addOpenAction();
}