@Inject
protected EntityDiffViewer diffFrame;

@Override
protected void postInit() {
    if (!PersistenceHelper.isNew(getItem())) {
        diffFrame.loadVersions(getItem());
    }
}