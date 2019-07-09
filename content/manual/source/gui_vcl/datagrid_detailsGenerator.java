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

    Component closeButton = createCloseButton(order);
    headerBox.add(infoLabel);
    headerBox.add(closeButton);
    headerBox.expand(infoLabel);

    Component content = getContent(order); 

    mainLayout.add(headerBox);
    mainLayout.add(content);
    mainLayout.expand(content);

    return mainLayout;
}

private Component createCloseButton(Order entity) {
    Button closeButton = uiComponents.create(Button.class);
    // ... <1>
    return closeButton;
}

private Component getContent(Order entity) {
    Label<String> content = uiComponents.create(Label.TYPE_STRING);
    content.setHtmlEnabled(true);
    StringBuilder sb = new StringBuilder();
    // ... <2>
    content.setValue(sb.toString());
    return content;
}

