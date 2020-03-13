@Subscribe("tree")
public void onTreeCollapse(Tree.CollapseEvent<Task> event) {
    notifications.create()
            .withCaption("Collapsed: " + event.getCollapsedItem().getName())
            .show();
}