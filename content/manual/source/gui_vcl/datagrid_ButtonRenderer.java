@Inject
private DataGrid<Customer> customersDataGrid;

@Inject
private Notifications notifications;

@Subscribe
public void onInit(InitEvent event) {
    DataGrid.ButtonRenderer<Customer> customersDataGridNameRenderer = 
	        customersDataGrid.createRenderer(DataGrid.ButtonRenderer.class);
    customersDataGridNameRenderer.setRendererClickListener(clickableButtonRendererClickEvent ->
        {
            notifications.create()
                .withType(Notifications.NotificationType.TRAY)
                .withCaption("ButtonRenderer")
                .withDescription("Column id: " + clickableButtonRendererClickEvent.getColumnId())
                .show();
        });
    customersDataGrid.getColumn("name").setRenderer(customersDataGridNameRenderer);
}