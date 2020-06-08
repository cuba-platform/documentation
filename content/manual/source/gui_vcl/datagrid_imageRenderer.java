@Inject
private DataGrid<TestEntity> testEntitiesDataGrid;
@Inject
private Notifications notifications;

@Subscribe
public void onInit(InitEvent event) {
    DataGrid.ImageRenderer<TestEntity> imageRenderer = 
            testEntitiesDataGrid.createRenderer(DataGrid.ImageRenderer.class);
    imageRenderer.setRendererClickListener(imageRendererClickEvent -> notifications.create()
            .withType(Notifications.NotificationType.TRAY)
            .withCaption("ImageRenderer")
            .withDescription("Column id: " + imageRendererClickEvent.getColumnId())
            .show());
    testEntitiesDataGrid.getColumn("imageRendererColumn").setRenderer(imageRenderer);
}