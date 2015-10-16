@Inject
private DataManager dataManager;

private void saveBookInstances(List<BookInstance> toSave, List<BookInstance> toDelete) {
    CommitContext commitContext = new CommitContext(toSave, toDelete);
    dataManager.commit(commitContext);
}

private Set<Entity> saveAndReturnBookInstances(List<BookInstance> toSave, View view) {
    CommitContext commitContext = new CommitContext();
    for (BookInstance bookInstance : toSave) {
        commitContext.addInstanceToCommit(bookInstance, view);
    }
    return dataManager.commit(commitContext);
}