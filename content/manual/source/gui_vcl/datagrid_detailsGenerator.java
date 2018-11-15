ordersGrid.setDetailsGenerator(new DataGrid.DetailsGenerator<Order>() {
    @Nullable
    @Override
    public Component getDetails(Order entity) {
        VBoxLayout mainLayout = uiComponents.create(VBoxLayout.NAME);
        mainLayout.setWidth("100%");
        mainLayout.setMargin(true);

        HBoxLayout headerBox = uiComponents.create(HBoxLayout.NAME);
        headerBox.setWidth("100%");

        Label infoLabel = uiComponents.create(Label.NAME);
        infoLabel.setHtmlEnabled(true);
        infoLabel.setStyleName("h1");
        infoLabel.setValue("Order info:");

        Component closeButton = createCloseButton(entity);
        headerBox.add(infoLabel);
        headerBox.add(closeButton);
        headerBox.expand(infoLabel);

        Component contentLabel = getContentLabel(entity);

        mainLayout.add(headerBox);
        mainLayout.add(contentLabel);
        mainLayout.expand(contentLabel);

        return mainLayout;
    }
});