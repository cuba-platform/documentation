@Inject
private CollectionLoader<Customer> customersDl;

@Subscribe("nameFilterField")
private void onNameFilterFieldValueChange(HasValue.ValueChangeEvent<String> event) {
    if (event.getValue() != null) {
        customersDl.setParameter("name", "(?i)%" + event.getValue() + "%"); // <1>
    } else {
        customersDl.removeParameter("name");
    }
    customersDl.load();
}

@Subscribe("statusFilterField")
private void onStatusFilterFieldValueChange(HasValue.ValueChangeEvent<Boolean> event) {
    if (event.getValue()) {
        customersDl.setParameter("status", true);
    } else {
        customersDl.removeParameter("status");
    }
    customersDl.load();
}
