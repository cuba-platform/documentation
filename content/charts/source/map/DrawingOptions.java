DrawingOptions options = new DrawingOptions();
PolygonOptions polygonOptions = new PolygonOptions(true, true, "#993366", 0.6);
ControlOptions controlOptions = new ControlOptions(
Position.TOP_CENTER, Arrays.asList(OverlayType.POLYGON));
options.setEnableDrawingControl(true);
options.setPolygonOptions(polygonOptions);
options.setDrawingControlOptions(controlOptions);
options.setInitialDrawingMode(OverlayType.POLYGON);
map.setDrawingOptions(options);