@Inject
private DataManager dataManager;

private Book loadBookById(UUID bookId) {
    LoadContext<Book> loadContext = LoadContext.create(Book.class)
            .setId(bookId).setView("book.edit");
    return dataManager.load(loadContext);
}

private List<BookPublication> loadBookPublications(UUID bookId) {
    LoadContext<BookPublication> loadContext = LoadContext.create(BookPublication.class)
            .setQuery(LoadContext.createQuery("select p from library$BookPublication p where p.book.id = :bookId")
                .setParameter("bookId", bookId))
            .setView("bookPublication.full");
    return dataManager.loadList(loadContext);
}