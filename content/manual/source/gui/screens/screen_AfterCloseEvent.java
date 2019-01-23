@Subscribe
protected void onAfterClose(AfterCloseEvent event) {
    notifications.create().withCaption("Just closed").show();
}