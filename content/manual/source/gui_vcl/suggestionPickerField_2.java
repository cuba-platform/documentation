suggestionPickerField.setArrowDownActionHandler(currentSearchString -> {
    List suggestions = findSuggestions();
    suggestionPickerField.showSuggestions(suggestions);
});

suggestionPickerField.setEnterActionHandler(currentSearchString -> {
    List suggestions = getDefaultSuggestions();
    suggestionPickerField.showSuggestions(suggestions);
});