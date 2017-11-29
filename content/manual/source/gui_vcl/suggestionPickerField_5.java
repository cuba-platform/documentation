List<String> strings = Arrays.asList("Red", "Green", "Blue", "Cyan", "Magenta", "Yellow");
stringSuggestionField.setSearchExecutor((searchString, searchParams) ->
        strings.stream()
                .filter(str -> StringUtils.containsIgnoreCase(str, searchString))
                .collect(Collectors.toList()));