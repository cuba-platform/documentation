@Inject
private UrlRouting urlRouting;

@Inject
private GroupTable<Customer> customersTable;

public void generateRoute() {
   Customer selectedCustomer = customersTable.getSingleSelected();
   if (selectedCustomer != null) {
      String routeToSelectedRole = urlRouting.getRouteGenerator()
         .getEditorRoute(selectedCustomer, ImmutableMap.of("someParam", "someValue"));

         UiControllerUtils.getScreenContext(this)
            .getDialogs()
            .createMessageDialog(Dialogs.MessageType.CONFIRMATION)
            .withCaption("Generated route")
            .withMessage(routeToSelectedRole)
            .withWidth("710")
            .show();
      }
}