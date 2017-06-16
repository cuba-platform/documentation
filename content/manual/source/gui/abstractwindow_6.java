@Inject
private CheckBox showPanel;

@Override
public void saveSettings() {
    boolean showPanelValue = showPanel.getValue();
    getSettings().get(showPanel.getId()).addAttribute("showPanel", String.valueOf(showPanelValue));
    super.saveSettings();
}