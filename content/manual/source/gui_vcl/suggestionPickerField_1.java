suggestionPickerField.setSearchExecutor(new SuggestionField.ParametrizedSearchExecutor(){
    @Override
    public Map<String, Object> getParams(){
        return ParamsMap.of(...);
    }

    @Override
    public List search(String searchString,Map searchParams){
        return executeSearch(searchString,searchParams);
    }
});