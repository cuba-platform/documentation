@Inject
private DataManager dataManager;

@Install(to = "customersDl", target = Target.DATA_LOADER)
protected List<Customer> customersDlLoadDelegate(LoadContext<Customer> loadContext) {
    return dataManager.loadList(loadContext);
}
