@Subscribe
protected void onInit(InitEvent event) {
    DataGrid.Column column = usersGrid.addGeneratedColumn("loginUpperCase", new DataGrid.ColumnGenerator<User, String>(){
        @Override
        public String getValue(DataGrid.ColumnGeneratorEvent<User> event){
            return event.getItem().getLogin().toUpperCase();
        }

        @Override
        public Class<String> getType(){
            return String.class;
        }
    }, 1);
    column.setCaption("Login Upper Case");
}