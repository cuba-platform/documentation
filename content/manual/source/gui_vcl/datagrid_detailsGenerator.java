ordersGrid.setDetailsGenerator(new DataGrid.DetailsGenerator<Order>() {
    @Nullable
    @Override
    public Component getDetails(Order entity) {
        VBoxLayout mainLayout = componentsFactory.createComponent(VBoxLayout.class);
        mainLayout.setWidth("100%");
        mainLayout.setMargin(true);

        HBoxLayout headerBox = componentsFactory.createComponent(HBoxLayout.class);
        headerBox.setWidth("100%");

        Label infoLabel = componentsFactory.createComponent(Label.class);
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