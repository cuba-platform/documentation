@Subscribe("tree")
public void onTreeExpand(Tree.ExpandEvent<Task> event) {
    notifications.create()
            .withCaption("Expanded: " + event.getExpandedItem().getName())
            .show();
}

@Subscribe("tree")
public void onTreeCollapse(Tree.CollapseEvent<Task> event) {
    notifications.create()
            .withCaption("Collapsed: " + event.getCollapsedItem().getName())
            .show();
}