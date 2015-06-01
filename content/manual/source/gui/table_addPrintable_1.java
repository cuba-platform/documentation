ordersTable.addPrintable("customer", new Table.Printable<Customer, String>() {
    @Override
    public String getValue(Customer customer) {
        return "Name: " + customer.getName;
    }
});