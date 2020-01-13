@Inject
protected Actions actions;

@Inject
protected Button execHistoryBtn;

@Subscribe
public void onInit(InitEvent event) {
    Action execHistoryAction = actions.create(ExecutionHistoryAction.class, "execHistoryReport");
    execHistoryBtn.setAction(execHistoryAction);
}