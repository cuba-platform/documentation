@Inject
protected DataGrid<User> usersGrid;
@Inject
private SourceCodeEditor suggesterCodeEditor;
@Inject
private CollectionContainer<User> usersDc;
@Inject
private CollectionLoader<User> usersDl;

@Subscribe
protected void onInit(InitEvent event) {
    suggesterCodeEditor.setSuggester((source, text, cursorPosition) -> {
        List<Suggestion> suggestions = new ArrayList<>();
        usersDl.load();
        for (User user : usersDc.getItems()) {
            suggestions.add(new Suggestion(source, user.getLogin(), user.getName(), null, -1, -1));
        }
        return suggestions;
    });
}
