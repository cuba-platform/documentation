Label label = map.createLabel();
label.setValue("<span style=\"color: #ffffff; font-size: 24px;\">White label</span>");
label.setPosition(map.createGeoPoint(42.955, 32.883));
label.setAdjustment(Label.Adjustment.BOTTOM_CENTER);
label.setContentType(Label.ContentType.HTML);
map.addLabel(label);