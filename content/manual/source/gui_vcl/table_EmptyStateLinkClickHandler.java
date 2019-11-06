@Install(to = "customersTable", subject = "emptyStateLinkClickHandler")
private void customersTableEmptyStateLinkClickHandler(Table.EmptyStateClickEvent<Customer> emptyStateClickEvent) {
    screenBuilders.editor(emptyStateClickEvent.getSource())
            .newEntity()
            .show();
}