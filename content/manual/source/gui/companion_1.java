public class CustomerBrowse extends AbstractLookup {

    public interface Companion {
        void initTable(Table<Customer> table);
    }

    @Inject
    protected Table<Customer> table;
    @Inject
    protected Companion companion;

    @Override
    public void init(Map<String, Object> params) {
        if (companion != null) {
            companion.initTable(table);
        }
    }
}