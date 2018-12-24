@Override
public void applySettings(Settings settings) {
    super.applySettings(settings);
    Element xmlDescriptor = settings.get(showPanel.getId());
    if (xmlDescriptor.attribute("showPanel") != null) {
        showPanel.setValue(Boolean.parseBoolean(xmlDescriptor.attributeValue("showPanel")));
    }
}