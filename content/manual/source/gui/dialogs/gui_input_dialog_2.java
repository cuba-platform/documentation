@Inject
private Dialogs dialogs;
@Inject
private UiComponents uiComponents;

@Subscribe("showDialogBtn")
private void onShowDialogBtnClick(Button.ClickEvent event) {
    dialogs.createInputDialog(this)
            .withCaption("Enter some values")
            .withParameters(
                    InputParameter.stringParameter("name").withCaption("Name"),
                    InputParameter.parameter("customer") // <1>
                            .withField(() -> {
                                LookupField<Customer> field = uiComponents.create(
                                        LookupField.of(Customer.class));
                                field.setOptionsList(dataManager.load(Customer.class).list());
                                field.setCaption("Customer"); // <2>
                                field.setWidthFull();
                                return field;
                            })
            )
            .withActions(DialogActions.OK_CANCEL)
            .withCloseListener(closeEvent -> {
                if (closeEvent.closedWith(DialogOutcome.OK)) {
                    String name = closeEvent.getValue("name");
                    Customer customer = closeEvent.getValue("customer"); // <3>
                    // process entered values...
                }
            })
            .show();
}
