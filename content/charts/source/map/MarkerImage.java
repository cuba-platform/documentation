MarkerImage markerImage = map.createMarkerImage("https://www.cuba-platform.com/sites/logo.png");
GeoPoint center = map.createGeoPoint(21.11, -76.20);
markerImage.setSize(map.createSize(44, 44));
markerImage.setOrigin(map.createPoint(0, 0));
markerImage.setAnchor(map.createPoint(-5, 50));
Marker marker = map.createMarker("Cuba", center, true, markerImage);
map.addMarker(marker);