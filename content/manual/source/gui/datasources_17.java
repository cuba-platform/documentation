@Inject
protected CollectionPropertyDatasourceImpl<CategoryAttribute, UUID> categoryAttrsDs;

categoryAttrsDs.addListener(new DsListenerAdapter<CategoryAttribute>() {
    @Override
    public void stateChanged(Datasource ds, Datasource.State prevState, Datasource.State state) {
        if (state != Datasource.State.VALID) return;

        initDataTypeColumn();
        initDefaultValueColumn();
    }
});