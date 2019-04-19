@Inject
private DataGrid<Order> ordersDataGrid;
@Inject
private UiComponents uiComponents;

@Install(to = "ordersDataGrid", subject = "detailsGenerator")
protected Component ordersDataGridDetailsGenerator(Order order) {
    VBoxLayout mainLayout = uiComponents.create(VBoxLayout.NAME);
    mainLayout.setWidth("100%");
    mainLayout.setMargin(true);

    HBoxLayout headerBox = uiComponents.create(HBoxLayout.NAME);
    headerBox.setWidth("100%");

    Label infoLabel = uiComponents.create(Label.NAME);
    infoLabel.setHtmlEnabled(true);
    infoLabel.setStyleName("h1");
    infoLabel.setValue("Order info:");

    Component closeButton = createCloseButton(order); // <1>
    headerBox.add(infoLabel);
    headerBox.add(closeButton);
    headerBox.expand(infoLabel);

    Component content = getContent(order); // <2>

    mainLayout.add(headerBox);
    mainLayout.add(content);
    mainLayout.expand(content);

    return mainLayout;
}