List<SendingStatus> enums = Arrays.asList(SendingStatus.values());
enumSuggestionField.setSearchExecutor((searchString, searchParams) ->
        enums.stream()
                .map(sendingStatus -> messages.getMessage(sendingStatus))
                .filter(str -> StringUtils.containsIgnoreCase(str, searchString))
                .collect(Collectors.toList()));