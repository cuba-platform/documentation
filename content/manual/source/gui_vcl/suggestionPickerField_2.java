suggestionPickerField.setArrowDownActionHandler(currentSearchString -> {
    List<Customer> suggestions = findSuggestions();
    suggestionPickerField.showSuggestions(suggestions);
});

suggestionPickerField.setEnterActionHandler(currentSearchString -> {
    List<Customer> suggestions = getDefaultSuggestions();
    suggestionPickerField.showSuggestions(suggestions);
});