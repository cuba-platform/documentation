public class CustomerEditor extends AbstractEditor<Customer> {

    @Inject
    private EntityStates entityStates;
    @Inject
    protected EntityDiffViewer diffFrame;

...
    @Override
    protected void postInit() {
        if (!entityStates.isNew(getItem())) {
            diffFrame.loadVersions(getItem());
        }
    }
}