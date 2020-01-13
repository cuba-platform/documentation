@Inject
protected Actions actions;

@Inject
protected Button listPrintBtn;

@Inject
private GroupTable<Author> authorsTable;

@Subscribe
public void onInit(InitEvent event) {
    Action listPrintFormAction = actions.create(ListPrintFormAction.class, "listPrintFormAction");
    authorsTable.addAction(listPrintFormAction);
    listPrintBtn.setAction(listPrintFormAction);
}