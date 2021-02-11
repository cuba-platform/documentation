public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private EntityStates entityStates;
    @Inject
    protected EntityDiffViewer diffFrame;
    @Inject
    InstanceContainer <Order> orderDc;
...
    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
       if (!entityStates.isNew(orderDc.getItem())) {
            diffFrame.loadVersions(orderDc.getItem());
        }
    }
}
