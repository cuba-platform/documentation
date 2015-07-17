@Inject
private SearchPickerField colourField;

@Override
public void init(Map<String, Object> params) {
    colourField.setSearchNotifications(new SearchField.SearchNotifications() {
        @Override
        public void notFoundSuggestions(String filterString) {
            showNotification("No colours found for search string: " + filterString,
                             NotificationType.TRAY);
        }

        @Override
        public void needMinSearchStringLength(String filterString, int minSearchStringLength) {
            showNotification("Minimum length of search string is " + minSearchStringLength,
                             NotificationType.TRAY);
        }
    });
}