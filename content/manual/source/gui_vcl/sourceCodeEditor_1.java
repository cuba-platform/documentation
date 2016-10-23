@Inject
private SourceCodeEditor suggesterCodeEditor;
@Inject
private CollectionDatasource<User, UUID> usersDs;

@Override
public void init(Map<String, Object> params) {
    suggesterCodeEditor.setSuggester((source, text, cursorPosition) -> {
        List<Suggestion> suggestions = new ArrayList<>();
        usersDs.refresh();
        for (User user : usersDs.getItems()) {
            suggestions.add(new Suggestion(source, user.getLogin(), user.getName(), null, -1, -1));
        }
        return suggestions;
    });
}