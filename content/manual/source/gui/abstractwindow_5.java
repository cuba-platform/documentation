public void applySettings(Settings settings) {
    super.applySettings(settings);
    String visible = settings.get(hintBox.getId()).attributeValue("visible");
    if (visible != null)
        hintBox.setVisible(Boolean.valueOf(visible));
}