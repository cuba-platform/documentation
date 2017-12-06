customersDs.refresh();
List<Customer> customers = new ArrayList<>(customersDs.getItems());
suggestionField.setSearchExecutor((searchString, searchParams) ->
        customers.stream()
                .filter(customer -> StringUtils.containsIgnoreCase(customer.getName(), searchString))
                .collect(Collectors.toList()));