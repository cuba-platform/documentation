@Inject
private Tree<Department> tree;

@Subscribe
protected void onInit(InitEvent event) {
    tree.setIconProvider(department -> {
        if (department.getParentDept() == null) {
            return "icons/root.png";
        }
        return "icons/leaf.png";
    });
}