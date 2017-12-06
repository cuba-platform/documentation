List<OptionWrapper> wrappers = Arrays.asList(
        new OptionWrapper("One", 1),
        new OptionWrapper("Two", 2),
        new OptionWrapper("Three", 3);
suggestionField.setSearchExecutor((searchString, searchParams) ->
        wrappers.stream()
                .filter(optionWrapper -> StringUtils.containsIgnoreCase(optionWrapper.getCaption(), searchString))
                .collect(Collectors.toList()));