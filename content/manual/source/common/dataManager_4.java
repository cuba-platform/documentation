@Inject
private DataManager dataManager;

private Book loadBookById(UUID bookId) {
    return dataManager.load(Book.class).id(bookId).view("book.edit").one();
}

private List<BookPublication> loadBookPublications(UUID bookId) {
    return dataManager.load(BookPublication.class)
        .query("select p from library_BookPublication p where p.book.id = :bookId")
        .parameter("bookId", bookId)
        .view("bookPublication.full")
        .list();
}
