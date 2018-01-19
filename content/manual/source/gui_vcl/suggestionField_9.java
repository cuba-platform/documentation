suggestionField.setSearchExecutor((searchString, searchParams) -> {
    searchString = QueryUtils.escapeForLike(searchString);
    return dataManager.loadList(LoadContext.create(Customer.class).setQuery(
            LoadContext.createQuery("select c from sample$Customer c where c.name like :name order by c.name escape '\\'")
                .setParameter("name", "%" + searchString + "%")));
});