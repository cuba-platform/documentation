@Inject
private LookupField<Task> tasksBox;

@Inject
private UrlRouting urlRouting;

@Subscribe("taskChooseBtn")
protected void onTaskChooseBtnClick(Button.ClickEvent event) {
    Task task = tasksBox.getValue();

    if (task == null) {
        // remove params if no task chosen
        urlRouting.replaceState(this);
        return;
    }

    String serializedTaskId = UrlTools.serializeId(task.getId());

    if (serializedTaskId == null || serializedTaskId.isEmpty()) {
        // remove params if failed to serialize task id
        urlRouting.replaceState(this);
        return;
    }

    urlRouting.replaceState(this, ImmutableMap.of("task_id", serializedTaskId));
}