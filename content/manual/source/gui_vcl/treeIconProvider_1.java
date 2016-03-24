@Inject
private Tree<Region> tree;

@Override
public void init(Map<String, Object> params) {
    tree.setIconProvider(new ListComponent.IconProvider<Region>() {
        @Nullable
        @Override
        public String getItemIcon(Region entity) {
            if (entity.getParent() == null) {
                return "icons/root.png";
            }
            return "icons/leaf.png";
        }
    });
}