@Inject
private UrlRouting urlRouting;

@Inject
private GroupTable<Customer> customersTable;

@Inject
private Dialogs dialogs;

public void generateRoute() {
   Customer selectedCustomer = customersTable.getSingleSelected();
   if (selectedCustomer != null) {
      String routeToSelectedRole = urlRouting.getRouteGenerator()
         .getEditorRoute(selectedCustomer, ImmutableMap.of("someParam", "someValue"));

         dialogs.createMessageDialog()
                    .withCaption("Generated route")
                    .withMessage(routeToSelectedRole)
                    .withWidth("710")
                    .show();
      }
}