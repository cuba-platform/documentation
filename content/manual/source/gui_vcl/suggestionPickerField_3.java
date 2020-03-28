suggestionPickerField.setSearchExecutor((searchString, searchParams) -> {
    searchString = QueryUtils.escapeForLike(searchString);
    return dataManager.load(Customer.class)
            .query("e.name like ?1 order by e.name escape '\\'", "%" + searchString + "%")
            .list();
});