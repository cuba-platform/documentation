public class OrderEditor extends AbstractEditor {

    @Named("itemsTable.add")
    protected AddAction addAction;

    @Override
    public void init(Map<String, Object> params) {
        addAction.setWindowId("sales$Product.browse");
        addAction.setHandler(new Lookup.Handler() {
            @Override
            public void handleLookup(Collection items) {
                // some code
            }
        });
    }
}