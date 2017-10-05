@Override
public void init(Map<String, Object> params) {
    addAction(new SelectAction(this) {
        @Override
        protected Collection getSelectedItems(LookupComponent lookupComponent) {
            Set<MyEntity> selected = new HashSet<>();
            // ...
            return selected;
        }
    });
}