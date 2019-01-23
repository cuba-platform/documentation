@Subscribe
protected void onAfterShow(AfterShowEvent event) {
    notifications.create().withCaption("Just opened").show();
}