@Inject
protected Table carsTable;

@Inject
protected ComponentsFactory componentsFactory;

@Override
public void init(Map<String, Object> params) {
    carsTable.addGeneratedColumn("colour", new Table.ColumnGenerator() {
        @Override
        public Component generateCell(Entity entity) {
            LookupPickerField field = componentsFactory.createComponent(LookupPickerField.NAME);
            field.setDatasource(carsTable.getItemDatasource(entity), "colour");
            field.setOptionsDatasource(coloursDs);
            field.addLookupAction();
            field.addOpenAction();
            return field;
        }
    });
}