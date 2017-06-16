@Override
public void applySettings(Settings settings) {
    super.applySettings(settings);
    if (settings.get(showPanel.getId()).attribute("showPanel") != null) {
        showPanel.setValue(Boolean.parseBoolean(settings.get().attributeValue("showPanel")));
    }
}