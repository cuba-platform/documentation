@Subscribe("tree")
public void onTreeExpand(Tree.ExpandEvent<Task> event) {
    notifications.create()
            .withCaption("Expanded: " + event.getExpandedItem().getName())
            .show();
}