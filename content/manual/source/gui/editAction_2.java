@Named("customersTable.edit")
private EditAction customersTableEdit;

@Override
public void init(Map<String, Object> params) {
    customersTableEdit.setAfterCommitHandler(new EditAction.AfterCommitHandler() {
        @Override
        public void handle(Entity entity) {
            showNotification("Committed", NotificationType.HUMANIZED);
        }
    });
}