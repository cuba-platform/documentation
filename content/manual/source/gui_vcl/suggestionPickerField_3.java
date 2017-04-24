public class OrderEdit extends AbstractEditor<Order> {

    @Inject
    private SuggestionPickerField suggestionPickerField;

    @Inject
    private DataManager dataManager;

    @Override
    public void init(Map<String, Object> params) {
        suggestionPickerField.setSearchExecutor((searchString, searchParams) ->
                dataManager.loadList(LoadContext.create(Customer.class).setQuery(
                    LoadContext.createQuery("select c from sample$Customer c where c.name like :name order by c.name")
                        .setParameter("name", "%" + searchParams + "%"))));
    }
}