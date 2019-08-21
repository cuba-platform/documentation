@Subscribe("optionsList")
private void onOptionsListDoubleClick(OptionsList.DoubleClickEvent event) {
    notifications.create()
            .withCaption("Double clicked")
            .show();
}