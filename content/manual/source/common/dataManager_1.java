@Inject
private DataManager dataManager;

private Book loadBookById(UUID bookId) {
    LoadContext loadContext = new LoadContext(Book.class)
            .setId(bookId).setView("book.edit");
    return dataManager.load(loadContext);
}

private List<BookPublication> loadBookPublications(UUID bookId) {
    LoadContext loadContext = new LoadContext(BookPublication.class)
            .setView("bookPublication.full");
    loadContext.setQueryString("select p from library$BookPublication p where p.book.id = :bookId")
            .setParameter("bookId", bookId);
    return dataManager.loadList(loadContext);
}