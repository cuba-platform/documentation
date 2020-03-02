@Inject
private TextField<Integer> textField;

@Subscribe("slider")
private void onSliderValueChange(HasValue.ValueChangeEvent<Integer> event) {
  textField.setValue(event.getValue());
}