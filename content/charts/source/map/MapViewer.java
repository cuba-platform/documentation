@Inject
private MapViewer map;

@Override
public void init(Map<String, Object> params) {
    GeoPoint center = map.createGeoPoint(53.490905, -2.249558);
    map.setCenter(center);
}