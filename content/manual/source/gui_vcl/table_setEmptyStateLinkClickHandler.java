@Subscribe
public void onInit(InitEvent event) {
    customersTable.setEmptyStateLinkClickHandler(emptyStateClickEvent ->
                screenBuilders.editor(emptyStateClickEvent.getSource())
                    .newEntity()
                    .show());
}