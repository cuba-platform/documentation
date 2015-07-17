@Inject
private Table someTable;

@Override
public void init(Map<String, Object> params) {
    someTable.addGeneratedColumn("someColumn", new Table.ColumnGenerator<Colour>() {
        @Override
        public Component generateCell(Colour entity) {
            ...
        }
    });
}