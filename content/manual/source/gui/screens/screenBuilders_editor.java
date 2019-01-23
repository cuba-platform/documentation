@Inject
private ScreenBuilders screenBuilders;

private void editSelectedEntity(Customer entity) {
    screenBuilders.editor(Customer.class, this)
            .editEntity(entity)
            .build()
            .show();
}