@Inject
private TextField<BigDecimal> textField;

@Inject
private Slider<Integer> slider;

@Subscribe("slider")
private void onSliderValueChange(HasValue.ValueChangeEvent<Integer> event) {
  textField.setValue(event.getValue());
}
