@Inject
private Datasource<Driver> driverDs;
@Inject
private EntitySnapshotService entitySnapshotService;

@Override
protected boolean postCommit(boolean committed, boolean close) {
    if (committed) {
        entitySnapshotService.createSnapshot(driverDs.getItem(), driverDs.getView());
    }
    return super.postCommit(committed, close);
}