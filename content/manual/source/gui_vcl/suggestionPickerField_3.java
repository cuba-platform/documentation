public class OrderEdit extends AbstractEditor<Order> {

    @Inject
    private SuggestionPickerField suggestionPickerField;
    @Inject
    private CollectionDatasource<Customer, UUID> customersDs;

    @Override
    protected void initNewItem(Order item) {
        super.initNewItem(item);

        customersDs.refresh();

        List<Customer> customers = new ArrayList<>(customersDs.getItems());
        suggestionPickerField.setSearchExecutor((searchString, searchParams) ->
                customers.stream()
                        .filter(customer -> customer.getName().contains(searchString))
                        .collect(Collectors.toList()));
    }
}