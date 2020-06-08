@Inject
private DataGrid<Customer> customersDataGrid;

@Inject
private Notifications notifications;

@Subscribe
public void onInit(InitEvent event) {
    DataGrid.ClickableTextRenderer<Customer> customersDataGridNameRenderer = 
	        customersDataGrid.createRenderer(DataGrid.ClickableTextRenderer.class);
    customersDataGridNameRenderer.setRendererClickListener(clickableTextRendererClickEvent -> {
        notifications.create()
                .withType(Notifications.NotificationType.TRAY)
                .withCaption("ButtonRenderer")
                .withDescription("Column id: " + clickableTextRendererClickEvent.getColumnId())
                .show();
    });
    customersDataGrid.getColumn("name").setRenderer(customersDataGridNameRenderer);
}