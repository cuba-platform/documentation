suggestionPickerField.setSearchExecutor(new SuggestionField.ParametrizedSearchExecutor<Customer>(){
    @Override
    public Map<String, Object> getParams() {
        return ParamsMap.of(...);
    }

    @Override
    public List<Customer> search(String searchString, Map<String, Object> searchParams) {
        return executeSearch(searchString, searchParams);
    }
});