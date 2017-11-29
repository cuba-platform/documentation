suggestionPickerField.setSearchExecutor((searchString, searchParams) ->
        dataManager.loadList(LoadContext.create(Customer.class).setQuery(
            LoadContext.createQuery("select c from sample$Customer c where c.name like :name order by c.name")
                .setParameter("name", "%" + searchParams + "%"))));