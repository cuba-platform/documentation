@Inject
private Notifications notifications;
@Inject
private SearchPickerField colorField;

@Subscribe
protected void onInit(InitEvent event) {
    colorField.setSearchNotifications(new SearchField.SearchNotifications() {
        @Override
        public void notFoundSuggestions(String filterString) {
            notifications.create()
                    .withCaption("No colors found for search string: " + filterString)
                    .withType(Notifications.NotificationType.TRAY)
                    .show();
        }

        @Override
        public void needMinSearchStringLength(String filterString, int minSearchStringLength) {
            notifications.create()
                    .withCaption("Minimum length of search string is " + minSearchStringLength)
                    .withType(Notifications.NotificationType.TRAY)
                    .show();
        }
    });
}