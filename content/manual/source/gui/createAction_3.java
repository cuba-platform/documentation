@Named("customersTable.create")
private CreateAction customersTableCreate;

@Override
public void init(Map<String, Object> params) {
    customersTableCreate.setAfterCommitHandler(new CreateAction.AfterCommitHandler() {
        @Override
        public void handle(Entity entity) {
            showNotification("Committed", NotificationType.HUMANIZED);
        }
    });
}