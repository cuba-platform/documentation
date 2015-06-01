ordersTable.addGeneratedColumn("product", new Table.PrintableColumnGenerator<Order, String>() {
    @Override
    public Component generateCell(Order entity) {
        Label label = componentsFactory.createComponent(Label.NAME);
        Product product = order.getProduct();
        label.setValue(product.getName() + ", " + product.getCost());
        return label;
    }

    @Override
    public String getValue(Order entity) {
        Product product = order.getProduct();
        return product.getName() + ", " + product.getCost();
    }
});