@Inject
private UrlRouting urlRouting;

@Subscribe("taskChooseBtn")
protected void onTaskChooseBtnClick(Button.ClickEvent event) {
    Task task = tasksBox.getValue();

    if (task == null) {
        urlRouting.replaceState(this);
        return;
    }

    String serializedTaskId = UrlTools.serializeId(task.getId());

    if (serializedTaskId == null || serializedTaskId.isEmpty()) {
        urlRouting.replaceState(this);
        return;
    }

    ImmutableMap<String, String> params = ImmutableMap.of("task_id", serializedTaskId);

    urlRouting.replaceState(this, params);

    // fire event
    fireEvent(UrlParamsChangedEvent.class, new UrlParamsChangedEvent(this, params));
}