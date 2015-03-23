pieChart.addSlicePullOutListener(new Chart.SlicePullOutListener() {
    @Override
    public void onPullOut(Chart.SlicePullOutEvent event) {
        BooksByGenre booksByGenre = (BooksByGenre) event.getItem();
        String msg = booksByGenre.getGenre() + ": " + booksByGenre.getCountOfBooks() + " book(s)";
        showNotification(msg, NotificationType.HUMANIZED);
    }
});
