@Inject
private CollectionDatasource bookInstanceDs;

public void refreshData(Timer timer) {
    bookInstanceDs.refresh();
}