@Named("customersTable.remove")
private RemoveAction customersTableRemove;

@Override
public void init(Map<String, Object> params) {
    customersTableRemove.setAfterRemoveHandler(new RemoveAction.AfterRemoveHandler() {
        @Override
        public void handle(Set removedItems) {
            showNotification("Removed", NotificationType.HUMANIZED);
        }
    });
}