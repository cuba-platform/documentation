@Inject
private UiComponents uiComponents;

@Install(to = "dataGrid.fullName", subject = "columnGenerator")
protected Component fullNameColumnGenerator(DataGrid.ColumnGeneratorEvent<Customer> e) {
    Label<String> label = uiComponents.create(Label.TYPE_STRING);
    label.setValue(e.getItem().getFirstName() + " " + e.getItem().getLastName());
    return label;
}