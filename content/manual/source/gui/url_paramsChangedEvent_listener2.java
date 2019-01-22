@Inject
private Notifications notifications;

@Subscribe
protected void onUrlParamsChanged(UrlParamsChangedEvent event) {
    String serializedTaskId = event.getParams().get("task_id");
    UUID taskId = (UUID) UrlIdSerializer.deserializeId(UUID.class, serializedTaskId);
}