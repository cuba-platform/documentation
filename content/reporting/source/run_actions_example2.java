@Inject
protected Actions actions;

@Inject
protected Button runReportBtn;

@Subscribe
public void onInit(InitEvent event) {
    Action runReportAction = actions.create(RunReportAction.class, "runReport");
    runReportBtn.setAction(runReportAction);
}