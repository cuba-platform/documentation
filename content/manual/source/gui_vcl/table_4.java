public void linkedMethod(Entity item, String columnId) {
    Customer customer = (Customer) item;
    showNotification(customer.getName());
}