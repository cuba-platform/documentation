@Inject
private MapViewer map;

@Subscribe
protected void onInit(InitEvent event) {
    GeoPoint center = map.createGeoPoint(53.490905, -2.249558);
    map.setCenter(center);
}