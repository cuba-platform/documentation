@Inject
private ScreenBuilders screenBuilders;

@Subscribe("customersTable.view")
public void onCustomersTableView(Action.ActionPerformedEvent event) {
    CustomerEdit customerEdit = screenBuilders.editor(customersTable)
            .withOpenMode(OpenMode.DIALOG)
            .withScreenClass(CustomerEdit.class)
            .withAfterCloseListener(afterScreenCloseEvent -> {
                if (afterScreenCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                    Customer committedCustomer = (afterScreenCloseEvent.getScreen()).getEditedEntity();
                    System.out.println("Updated " + committedCustomer);
                }
            })
            .build();
    customerEdit.setReadOnly(true);
    customerEdit.show();
}
