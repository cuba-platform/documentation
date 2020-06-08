@Inject
private DataGrid<User> usersGrid;

@Subscribe
protected void onInit(InitEvent event) {

    DataGrid.Column<User> hasEmail = usersGrid.addGeneratedColumn("hasEmail", new DataGrid.ColumnGenerator<User, Boolean>() {
        @Override
        public Boolean getValue(DataGrid.ColumnGeneratorEvent<User> event) {
            return StringUtils.isNotEmpty(event.getItem().getEmail());
        }

        @Override
        public Class<Boolean> getType() {
            return Boolean.class;
        }
    });

    hasEmail.setCaption("Has Email");
    hasEmail.setRenderer(
        usersGrid.createRenderer(DataGrid.HtmlRenderer.class),
        (Function<Boolean, String>) hasEmailValue -> {
            return BooleanUtils.isTrue(hasEmailValue)
                    ? FontAwesome.PLUS_SQUARE.getHtml()
                    : FontAwesome.MINUS_SQUARE.getHtml();
        });
}