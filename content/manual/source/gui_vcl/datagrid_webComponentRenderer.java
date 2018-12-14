@Inject
private DataGrid<User> usersGrid;
@Inject
private UiComponents uiComponents;
@Inject
private Configuration configuration;
@Inject
private Messages messages;

@Subscribe
protected void onInit(InitEvent event) {
    Map<String, Locale> locales = configuration.getConfig(GlobalConfig.class).getAvailableLocales();
    Map<String, String> options = new TreeMap<>();
    for (Map.Entry<String, Locale> entry : locales.entrySet()) {
        options.put(entry.getKey(), messages.getTools().localeToString(entry.getValue()));
    }

    DataGrid.Column column = usersGrid.addGeneratedColumn("language",
            new DataGrid.ColumnGenerator<User, Component>() {
                @Override
                public Component getValue(DataGrid.ColumnGeneratorEvent<User> event) {
                    LookupField<String> component = uiComponents.create(LookupField.NAME);
                    component.setOptionsMap(options);
                    component.setWidth("100%");

                    User user = event.getItem();
                    component.setValue(user.getLanguage());

                    component.addValueChangeListener(e -> user.setLanguage(e.getValue()));

                    return component;
                }

                @Override
                public Class<Component> getType() {
                    return Component.class;
                }
            });

    column.setRenderer(new WebComponentRenderer());
}
