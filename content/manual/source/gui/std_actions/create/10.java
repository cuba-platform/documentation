@Inject
private ScreenBuilders screenBuilders;

@Subscribe("customersTable.create")
public void onCustomersTableCreate(Action.ActionPerformedEvent event) {
    screenBuilders.editor(customersTable)
            .newEntity()
            .withOpenMode(OpenMode.DIALOG)
            .withScreenClass(CustomerEdit.class)
            .withAfterCloseListener(afterScreenCloseEvent -> {
                if (afterScreenCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                    Customer committedCustomer = (afterScreenCloseEvent.getScreen()).getEditedEntity();
                    System.out.println("Created " + committedCustomer);
                }
            })
            .build()
            .show();
}
