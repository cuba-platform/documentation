public class CustomerEditor extends AbstractEditor<Customer> {

    @Inject
    protected Datasource<Customer> customerDs;
    @Inject
    protected EntitySnapshotService entitySnapshotService;

...
    @Override
    protected boolean postCommit(boolean committed, boolean close) {
        if (committed) {
            entitySnapshotService.createSnapshot(customerDs.getItem(), customerDs.getView());
        }
        return super.postCommit(committed, close);
    }
}