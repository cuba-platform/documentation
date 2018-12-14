@Inject
private DataGrid<Customer> customersDataGrid;

@Subscribe
protected void onInit(InitEvent event) {
    customersDataGrid.getColumnNN("age").setDescriptionProvider(customer ->
                    getPropertyCaption(customer, "age") +
                            customer.getAge(),
            ContentMode.HTML);

    customersDataGrid.getColumnNN("active").setDescriptionProvider(customer ->
                    getPropertyCaption(customer, "active") +
                            getMessage(customer.getActive() ? "trueString" : "falseString"),
            ContentMode.HTML);

    customersDataGrid.getColumnNN("grade").setDescriptionProvider(customer ->
                    getPropertyCaption(customer, "grade") +
                            messages.getMessage(customer.getGrade()),
            ContentMode.HTML);
}
