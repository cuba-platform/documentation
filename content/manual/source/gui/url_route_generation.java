@Inject
private UrlRouting urlRouting;

@Inject
private GroupTable<Customer> customersTable;

@Inject
private Dialogs dialogs;

@Subscribe("getLinkButton")
public void onGetLinkButtonClick(Button.ClickEvent event) {
    Customer selectedCustomer = customersTable.getSingleSelected();
    if (selectedCustomer != null) {
        String routeToSelectedRole = urlRouting.getRouteGenerator()
                .getEditorRoute(selectedCustomer);

        dialogs.createMessageDialog()
                .withCaption("Generated route")
                .withMessage(routeToSelectedRole)
                .withWidth("710")
                .show();
    }
}