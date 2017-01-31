@Override
public void init(Map<String, Object> params){
    DataGrid.Column hasEmail = usersGrid.addGeneratedColumn("hasEmail", new DataGrid.ColumnGenerator<User, Boolean>() {
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
    hasEmail.setRenderer(usersGrid.createRenderer(DataGrid.HtmlRenderer.class));
    hasEmail.setConverter(new DataGrid.Converter<String, Boolean>() {
        @Override
        public Boolean convertToModel(String value, Class<? extends Boolean> targetType, Locale locale) {
            return null;
        }

        @Override
        public String convertToPresentation(Boolean value, Class<? extends String> targetType, Locale locale) {
            return BooleanUtils.isTrue(value)
                    ? FontAwesome.CHECK_SQUARE_O.getHtml()
                    : FontAwesome.SQUARE_O.getHtml();
        }

        @Override
        public Class<Boolean> getModelType() {
            return Boolean.class;
        }

        @Override
        public Class<String> getPresentationType() {
            return String.class;
        }
    });
}