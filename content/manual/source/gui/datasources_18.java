protected class StopDsListener extends CollectionDsListenerAdapter<Stop> {
    @Override
    public void valueChanged(Stop source, String property, Object prevValue, Object value) {
        // existing stop address changed
        if ("address".equals(property)) {
            fireRouteChanged();
        }
    }

    @Override
    public void collectionChanged(CollectionDatasource ds, Operation operation) {
        // stop was added or removed
        fireRouteChanged();
    }

    private void fireRouteChanged() {
        // journey route has changed, need to recalculate price, journey time, pickup time delay etc.
    }
}