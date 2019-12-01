@Inject
private ScreenBuilders screenBuilders;

@Subscribe("customersTable.edit")
public void onCustomersTableEdit(Action.ActionPerformedEvent event) {
    screenBuilders.editor(customersTable)
            .withOpenMode(OpenMode.DIALOG)
            .withScreenClass(CustomerEdit.class)
            .withAfterCloseListener(afterScreenCloseEvent -> {
                if (afterScreenCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                    Customer committedCustomer = (afterScreenCloseEvent.getScreen()).getEditedEntity();
                    System.out.println("Updated " + committedCustomer);
                }
            })
            .build()
            .show();
}
