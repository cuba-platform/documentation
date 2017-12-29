suggestionField.setSearchExecutor((searchString, searchParams) -> {
    return Arrays.asList(entity1, entity2, ...);
});