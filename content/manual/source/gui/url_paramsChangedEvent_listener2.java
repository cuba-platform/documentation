@Inject
private Notifications notifications;

@Subscribe
protected void onUrlParamsChanged(UrlParamsChangedEvent event) {
    String serializedTaskId = event.getParams().get("task_id");
    UUID taskId = UrlTools.deserialize(UUID.class, serializedTaskId);
}