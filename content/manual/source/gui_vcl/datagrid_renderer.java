@Subscribe
protected void onInit(InitEvent event) {
    DataGrid.Column avatar = usersGrid.addGeneratedColumn("userAvatar", new DataGrid.ColumnGenerator<User, String>() {
        @Override
        public String getValue(DataGrid.ColumnGeneratorEvent<User> event) {
            return "icons/user.png";
        }

        @Override
        public Class<String> getType() {
            return String.class;
        }
    }, 0);
    avatar.setCaption("Avatar");
    avatar.setRenderer(usersGrid.createRenderer(DataGrid.ImageRenderer.class));
}