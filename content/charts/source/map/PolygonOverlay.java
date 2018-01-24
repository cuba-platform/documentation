List<GeoPoint> coordinates = new ArrayList<>();
coordinates.add(map.createGeoPoint(48.560579, 7.767876));
coordinates.add(map.createGeoPoint(48.561386, 7.782791));
coordinates.add(map.createGeoPoint(48.541940, 7.782861));
coordinates.add(map.createGeoPoint(48.545641, 7.768749));
Polygon p = map.createPolygon(coordinates, "#9CFBA9", 0.6, "#2CA860", 1.0, 2);
map.addPolygonOverlay(p);