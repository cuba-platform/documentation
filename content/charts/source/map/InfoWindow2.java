map.addMarkerClickListener(event -> {
    Marker marker = event.getMarker();
    String caption = String.format("Marker clicked: %.2f, %.2f",
            marker.getPosition().getLatitude(),
            marker.getPosition().getLongitude());
    InfoWindow w = map.createInfoWindow(caption, marker);
    map.openInfoWindow(w);
});