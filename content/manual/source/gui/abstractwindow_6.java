@Inject
private CheckBox showPanel;

@Override
public void saveSettings() {
    boolean showPanelValue = showPanel.getValue();
    Element xmlDescriptor = getSettings().get(showPanel.getId());
    xmlDescriptor.addAttribute("showPanel", String.valueOf(showPanelValue));
    super.saveSettings();
}